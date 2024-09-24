package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID>, PagingAndSortingRepository<ProductEntity, UUID> {
}
