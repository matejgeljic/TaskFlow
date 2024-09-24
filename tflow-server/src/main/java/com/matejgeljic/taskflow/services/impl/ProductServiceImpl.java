package com.matejgeljic.taskflow.services.impl;

import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import com.matejgeljic.taskflow.exceptions.TaskFlowException;
import com.matejgeljic.taskflow.repositories.ProductRepository;
import com.matejgeljic.taskflow.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public boolean isExists(UUID id) {
        return productRepository.existsById(id);
    }

    @Override
    public ProductEntity reduceQuantity(UUID id, Integer quantity) {
        return productRepository.findById(id).map(item -> {
            if (item.getStockQuantity() < quantity) {
                throw new TaskFlowException("Stock quantity is too low", HttpStatus.BAD_REQUEST);
            }
            item.setStockQuantity(item.getStockQuantity() - quantity);
            return productRepository.save(item);
        }).orElseThrow(() -> new TaskFlowException("Product not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}