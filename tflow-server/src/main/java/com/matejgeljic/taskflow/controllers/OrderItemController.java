package com.matejgeljic.taskflow.controllers;

import com.matejgeljic.taskflow.domain.dto.OrderItemDto;
import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import com.matejgeljic.taskflow.services.OrderItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "order-items")
@RestController
@Tag(name = "Order Item")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final Mapper<OrderItemEntity, OrderItemDto> orderItemMapper;

    public OrderItemController(OrderItemService orderItemService, Mapper<OrderItemEntity, OrderItemDto> orderItemMapper) {
        this.orderItemService = orderItemService;
        this.orderItemMapper = orderItemMapper;
    }

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@Valid  @RequestBody OrderItemDto orderItem) {
        OrderItemEntity savedOrderItem = orderItemService.createOrderItem(orderItem);

        return new ResponseEntity<>(orderItemMapper.mapTo(savedOrderItem), HttpStatus.CREATED);
    }
}