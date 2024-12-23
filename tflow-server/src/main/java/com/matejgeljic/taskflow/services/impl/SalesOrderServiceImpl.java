package com.matejgeljic.taskflow.services.impl;

import com.matejgeljic.taskflow.domain.dto.OrderItemDto;
import com.matejgeljic.taskflow.domain.dto.SalesOrderDto;
import com.matejgeljic.taskflow.domain.dto.SalesOrderStatus;
import com.matejgeljic.taskflow.domain.entities.CustomerEntity;
import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import com.matejgeljic.taskflow.exceptions.TaskFlowException;
import com.matejgeljic.taskflow.repositories.CustomerRepository;
import com.matejgeljic.taskflow.repositories.OrderItemRepository;
import com.matejgeljic.taskflow.repositories.ProductRepository;
import com.matejgeljic.taskflow.repositories.SalesOrderRepository;
import com.matejgeljic.taskflow.services.ProductService;
import com.matejgeljic.taskflow.services.SalesOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    private final SalesOrderRepository salesOrderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public SalesOrderServiceImpl(SalesOrderRepository salesOrderRepository, CustomerRepository customerRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository, ProductService productService, ProductRepository productRepository1) {
        this.salesOrderRepository = salesOrderRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
        this.productService = productService;
        this.productRepository = productRepository1;
    }

    @Override
    public SalesOrderEntity createSalesOrder(SalesOrderDto salesOrderDto) {
        SalesOrderEntity salesOrderEntity = new SalesOrderEntity();

        UUID customerId = salesOrderDto.getCustomer().getId();
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new TaskFlowException("Customer not found", HttpStatus.NOT_FOUND));
        salesOrderEntity.setCustomer(customerEntity);

        List<OrderItemEntity> orderItems = new ArrayList<>();

        for (OrderItemDto itemDto : salesOrderDto.getOrderItems()) {
            UUID orderItemId = itemDto.getId();
            OrderItemEntity orderItemEntity = orderItemRepository.findById(orderItemId)
                    .orElseThrow(() -> new TaskFlowException("Order item not found", HttpStatus.NOT_FOUND));

            ProductEntity productEntity = orderItemEntity.getProduct();
            productService.reduceQuantity(productEntity.getId(), orderItemEntity.getQuantity());

            orderItems.add(orderItemEntity);
        }

        salesOrderEntity.setOrderItems(orderItems);
        salesOrderEntity.setStatus(salesOrderDto.getStatus());

        Double totalPrice = calculateTotalPrice(orderItems);
        salesOrderEntity.setTotalPrice(totalPrice);

        return salesOrderRepository.save(salesOrderEntity);
    }

    @Override
    public Page<SalesOrderEntity> findAll(Pageable pageable) {
        return salesOrderRepository.findAll(pageable);
    }

    @Override
    public boolean isExists(UUID id) {
        return salesOrderRepository.existsById(id);
    }

    @Override
    public SalesOrderEntity updateSalesOrderStatus(UUID id, SalesOrderStatus status) {
        return salesOrderRepository.findById(id).map(existingSalesOrder -> {
            if(SalesOrderStatus.CANCELLED.equals(status)) {
                for (OrderItemEntity orderItem  : existingSalesOrder.getOrderItems()) {
                    ProductEntity product = orderItem .getProduct();
                    product.setStockQuantity(product.getStockQuantity() + orderItem.getQuantity());
                    productRepository.save(product);
                }
            }
            existingSalesOrder.setStatus(status);
            return salesOrderRepository.save(existingSalesOrder);
        }).orElseThrow(() -> new TaskFlowException("Sales Order does not exist", HttpStatus.NOT_FOUND));
    }

    private Double calculateTotalPrice(List<OrderItemEntity> orderItems) {
        return orderItems.stream()
                .mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                .sum();
    }
}