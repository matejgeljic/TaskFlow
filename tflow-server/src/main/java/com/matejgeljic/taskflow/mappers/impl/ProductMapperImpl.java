package com.matejgeljic.taskflow.mappers.impl;

import com.matejgeljic.taskflow.domain.dto.ProductDto;
import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements Mapper<ProductEntity, ProductDto> {

    public ModelMapper modelMapper;

    public ProductMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto mapTo(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }

    @Override
    public ProductEntity mapFrom(ProductDto productDto) {
        return modelMapper.map(productDto, ProductEntity.class);
    }
}