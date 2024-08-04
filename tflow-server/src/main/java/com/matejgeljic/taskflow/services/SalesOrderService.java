package com.matejgeljic.taskflow.services;

import com.matejgeljic.taskflow.domain.dto.SalesOrderDto;
import com.matejgeljic.taskflow.domain.dto.SalesOrderStatus;
import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SalesOrderService {
    SalesOrderEntity createSalesOrder(SalesOrderDto salesOrderDto);

    Page<SalesOrderEntity> findAll(Pageable pageable);

    boolean isExists(Long id);

    SalesOrderEntity partialUpdateSalesOrder(Long id, SalesOrderStatus status);
}