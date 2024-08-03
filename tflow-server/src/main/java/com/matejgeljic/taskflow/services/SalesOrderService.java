package com.matejgeljic.taskflow.services;

import com.matejgeljic.taskflow.domain.dto.SalesOrderDto;
import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalesOrderService {
    SalesOrderEntity createSalesOrder(SalesOrderDto salesOrderDto);

    Page<SalesOrderEntity> findAll(Pageable pageable);

    boolean isExists(Long id);

    SalesOrderEntity partialUpdateSalesOrder(Long id, SalesOrderEntity salesOrderEntity);
}