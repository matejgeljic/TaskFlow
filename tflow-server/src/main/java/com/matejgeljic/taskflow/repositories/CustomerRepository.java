package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>, PagingAndSortingRepository<CustomerEntity, Long> {
}
