package com.matejgeljic.taskflow.services.impl;

import com.matejgeljic.taskflow.domain.dto.OrderItemDto;
import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import com.matejgeljic.taskflow.exceptions.TaskFlowException;
import com.matejgeljic.taskflow.repositories.OrderItemRepository;
import com.matejgeljic.taskflow.repositories.ProductRepository;
import com.matejgeljic.taskflow.services.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderItemEntity createOrderItem(OrderItemDto orderItemDto) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setQuantity(orderItemDto.getQuantity());

        Long productId = orderItemDto.getProduct().getId();
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new TaskFlowException("Product not found", HttpStatus.NOT_FOUND));

        orderItemEntity.setProduct(productEntity);

        if(productEntity.getStockQuantity() < orderItemDto.getQuantity()) {
            throw new TaskFlowException("Not enough stock for product: " + productEntity.getId(), HttpStatus.BAD_REQUEST);
        }

        return orderItemRepository.save(orderItemEntity);
    }
}