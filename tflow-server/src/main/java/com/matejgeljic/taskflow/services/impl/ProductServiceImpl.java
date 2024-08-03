package com.matejgeljic.taskflow.services.impl;

import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import com.matejgeljic.taskflow.repositories.ProductRepository;
import com.matejgeljic.taskflow.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public boolean isExists(Long id) {
        return productRepository.existsById(id);
    }

//    @Override
//    public ProductEntity reduceQuantity(Long id, Integer quantity) {
//
//        return productRepository.findById(id).map(item -> {
//            if(item.getStockQuantity() < quantity) {
//                throw new RuntimeException("Stock quantity is too low");
//            }
//
//            item.setStockQuantity(item.getStockQuantity() - quantity);
//            return productRepository.save(item);
//       }).orElseThrow(() -> new RuntimeException("Product not found"));
//    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}