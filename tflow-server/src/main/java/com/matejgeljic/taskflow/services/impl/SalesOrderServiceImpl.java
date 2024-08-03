package com.matejgeljic.taskflow.services.impl;

import com.matejgeljic.taskflow.domain.dto.OrderItemDto;
import com.matejgeljic.taskflow.domain.dto.SalesOrderDto;
import com.matejgeljic.taskflow.domain.entities.CustomerEntity;
import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import com.matejgeljic.taskflow.repositories.CustomerRepository;
import com.matejgeljic.taskflow.repositories.OrderItemRepository;
import com.matejgeljic.taskflow.repositories.ProductRepository;
import com.matejgeljic.taskflow.repositories.SalesOrderRepository;
import com.matejgeljic.taskflow.services.SalesOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    private final SalesOrderRepository salesOrderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;

    public SalesOrderServiceImpl(SalesOrderRepository salesOrderRepository, CustomerRepository customerRepository, OrderItemRepository orderItemRepository) {
        this.salesOrderRepository = salesOrderRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public SalesOrderEntity createSalesOrder(SalesOrderDto salesOrderDto) {
        SalesOrderEntity salesOrderEntity = new SalesOrderEntity();

        // Fetch and set customer entity
        Long customerId = salesOrderDto.getCustomer().getId();
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        salesOrderEntity.setCustomer(customerEntity);

        // Map order items from DTO
        List<OrderItemEntity> orderItems = salesOrderDto.getOrderItems().stream()
                .map(itemDto -> {
                    Long orderItemId = itemDto.getId(); // assuming you're passing order item ID here

                    // Link the order item entity if it already has the product info
                    return orderItemRepository.findById(orderItemId)
                            .orElseThrow(() -> new RuntimeException("Order item not found"));
                }).collect(Collectors.toList());

        salesOrderEntity.setOrderItems(orderItems);

        salesOrderEntity.setStatus(salesOrderDto.getStatus());
        salesOrderEntity.setTotalPrice(salesOrderDto.getTotalPrice());

        return salesOrderRepository.save(salesOrderEntity);
    }

    @Override
    public Page<SalesOrderEntity> findAll(Pageable pageable) {
        return salesOrderRepository.findAll(pageable);
    }

    @Override
    public boolean isExists(Long id) {
        return salesOrderRepository.existsById(id);
    }

    @Override
    public SalesOrderEntity partialUpdateSalesOrder(Long id, SalesOrderEntity salesOrderEntity) {
        salesOrderEntity.setId(id);

        return salesOrderRepository.findById(id).map(existingSalesOrder -> {
            Optional.ofNullable(salesOrderEntity.getStatus()).ifPresent(existingSalesOrder::setStatus);

            return salesOrderRepository.save(existingSalesOrder);
        }).orElseThrow(() -> new RuntimeException("Sales Order does not exist"));
    }

    private Double calculateTotalPrice(SalesOrderEntity salesOrder) {
        return salesOrder.getOrderItems().stream()
                .mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                .sum();
    }
}