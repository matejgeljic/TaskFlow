package com.matejgeljic.taskflow.controllers;

import com.matejgeljic.taskflow.domain.dto.ProductDto;
import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import com.matejgeljic.taskflow.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "products")
@RestController
@Tag(name = "Product")
public class ProductController {

    private final ProductService productService;

    private final Mapper<ProductEntity, ProductDto> productMapper;

    public ProductController(ProductService productService, Mapper<ProductEntity, ProductDto> productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
        ProductEntity productEntity = productMapper.mapFrom(product);
        ProductEntity savedProductEntity = productService.saveProduct(productEntity);
        return new ResponseEntity<>(productMapper.mapTo(savedProductEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public Page<ProductDto> getProducts(Pageable pageable) {
        Page<ProductEntity> products = productService.findAll(pageable);

        return products.map(productMapper::mapTo);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductDto> fullUpdateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDto productDto) {
        if(!productService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productDto.setId(id);
        ProductEntity productEntity = productMapper.mapFrom(productDto);

        ProductEntity savedProductEntity = productService.saveProduct(productEntity);
        return new ResponseEntity<>(productMapper.mapTo(savedProductEntity), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteProduct (@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
