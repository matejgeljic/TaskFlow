package com.matejgeljic.taskflow.mappers.impl;

import com.matejgeljic.taskflow.domain.dto.OrderItemDto;
import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapperImpl implements Mapper<OrderItemEntity, OrderItemDto> {
    public ModelMapper modelMapper;

    public OrderItemMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderItemDto mapTo(OrderItemEntity orderItemEntity) {
        return modelMapper.map(orderItemEntity, OrderItemDto.class);
    }

    @Override
    public OrderItemEntity mapFrom(OrderItemDto orderItemDto) {
        return modelMapper.map(orderItemDto, OrderItemEntity.class);
    }
}