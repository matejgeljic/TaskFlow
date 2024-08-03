package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>, PagingAndSortingRepository<ProductEntity, Long> {
}
