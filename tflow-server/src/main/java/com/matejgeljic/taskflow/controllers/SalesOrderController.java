package com.matejgeljic.taskflow.controllers;

import com.matejgeljic.taskflow.domain.dto.SalesOrderDto;
import com.matejgeljic.taskflow.domain.dto.SalesOrderStatusUpdateDto;
import com.matejgeljic.taskflow.domain.entities.SalesOrderEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import com.matejgeljic.taskflow.services.SalesOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(path = "sales-orders")
@RestController
@Tag(name = "Sales Order")
public class SalesOrderController {
    private final SalesOrderService salesOrderService;
    private final Mapper<SalesOrderEntity, SalesOrderDto> salesOrderMapper;

    public SalesOrderController(SalesOrderService salesOrderService, Mapper<SalesOrderEntity, SalesOrderDto> salesOrderMapper) {
        this.salesOrderService = salesOrderService;
        this.salesOrderMapper = salesOrderMapper;
    }

    @PostMapping
    public ResponseEntity<SalesOrderDto> createSalesOrder(@Valid  @RequestBody SalesOrderDto salesOrder) {
        SalesOrderEntity savedSalesOrder = salesOrderService.createSalesOrder(salesOrder);
        return new ResponseEntity<>(salesOrderMapper.mapTo(savedSalesOrder), HttpStatus.CREATED);
    }

    @GetMapping
    public Page<SalesOrderDto> getSalesOrders(Pageable pageable) {
        Page<SalesOrderEntity> salesOrders = salesOrderService.findAll(pageable);

        return salesOrders.map(salesOrderMapper::mapTo);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<SalesOrderDto> updateSalesOrderStatus(
            @PathVariable("id") UUID id,
            @Valid @RequestBody SalesOrderStatusUpdateDto status
    ) {
        if(!salesOrderService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        SalesOrderEntity updatedSalesOrder = salesOrderService.updateSalesOrderStatus(id, status.getStatus());
        return new ResponseEntity<>(salesOrderMapper.mapTo(updatedSalesOrder), HttpStatus.OK);
    }
}
