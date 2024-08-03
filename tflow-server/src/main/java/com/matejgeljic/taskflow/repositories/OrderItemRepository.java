package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long> {
}
