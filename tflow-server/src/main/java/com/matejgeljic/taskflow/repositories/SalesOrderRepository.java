package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SalesOrderRepository extends CrudRepository<SalesOrderEntity, Long>, PagingAndSortingRepository<SalesOrderEntity, Long> {
}
