package com.matejgeljic.taskflow.repositories;

import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, UUID> {
}
