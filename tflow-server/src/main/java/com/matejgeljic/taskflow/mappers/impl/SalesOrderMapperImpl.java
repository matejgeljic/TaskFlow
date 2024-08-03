package com.matejgeljic.taskflow.mappers.impl;

import com.matejgeljic.taskflow.domain.dto.SalesOrderDto;
import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SalesOrderMapperImpl implements Mapper<SalesOrderEntity, SalesOrderDto> {
    public ModelMapper modelMapper;

    public SalesOrderMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SalesOrderDto mapTo(SalesOrderEntity salesOrder) {
        return modelMapper.map(salesOrder, SalesOrderDto.class);
    }

    @Override
    public SalesOrderEntity mapFrom(SalesOrderDto salesOrderDto) {
        return modelMapper.map(salesOrderDto, SalesOrderEntity.class);
    }
}