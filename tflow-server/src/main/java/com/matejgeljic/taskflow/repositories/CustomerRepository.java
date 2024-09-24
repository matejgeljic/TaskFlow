package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID>, PagingAndSortingRepository<CustomerEntity, UUID> {
}
