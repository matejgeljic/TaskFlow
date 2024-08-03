package com.matejgeljic.taskflow.services;

import com.matejgeljic.taskflow.domain.dto.OrderItemDto;
import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;

public interface OrderItemService {
    OrderItemEntity createOrderItem(OrderItemDto orderItemDto);
}
