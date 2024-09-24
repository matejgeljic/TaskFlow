package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface SalesOrderRepository extends CrudRepository<SalesOrderEntity, UUID>, PagingAndSortingRepository<SalesOrderEntity, UUID> {
}
