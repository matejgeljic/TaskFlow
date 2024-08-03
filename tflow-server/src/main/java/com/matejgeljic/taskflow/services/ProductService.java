package com.matejgeljic.taskflow.services;

import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductEntity saveProduct(ProductEntity productEntity);

    Page<ProductEntity> findAll(Pageable pageable);

    boolean isExists(Long id);

//    ProductEntity reduceQuantity(Long id, Integer quantity);

    void deleteProduct(Long id);
}
