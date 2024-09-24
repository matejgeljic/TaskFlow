package com.matejgeljic.taskflow.services;

import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    ProductEntity saveProduct(ProductEntity productEntity);

    Page<ProductEntity> findAll(Pageable pageable);

    boolean isExists(UUID id);

    ProductEntity reduceQuantity(UUID id, Integer quantity);

    void deleteProduct(UUID id);
}
