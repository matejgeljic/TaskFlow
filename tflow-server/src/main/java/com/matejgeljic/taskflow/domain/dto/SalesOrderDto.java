package com.matejgeljic.taskflow.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrderDto {
    private UUID id;
    @NotNull(message = "400")
    private CustomerDto customer;
    @NotNull(message = "401")
    private List<OrderItemDto> orderItems;
    @NotNull(message = "402")
    private SalesOrderStatus status;
    @JsonIgnore
    private Double totalPrice;
}