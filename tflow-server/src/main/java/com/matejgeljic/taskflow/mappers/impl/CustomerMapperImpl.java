package com.matejgeljic.taskflow.mappers.impl;

import com.matejgeljic.taskflow.domain.dto.CustomerDto;
import com.matejgeljic.taskflow.domain.entities.CustomerEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements Mapper<CustomerEntity, CustomerDto> {
    public ModelMapper modelMapper;

    public CustomerMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto mapTo(CustomerEntity customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerEntity mapFrom(CustomerDto customerDto) {
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
}