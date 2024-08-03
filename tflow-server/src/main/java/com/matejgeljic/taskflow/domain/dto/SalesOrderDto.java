package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesOrderDto {
    private Long id;
    @NotNull(message = "400")
    @NotEmpty(message = "400")
    private CustomerDto customer;
    @NotNull(message = "401")
    @NotEmpty(message = "401")
    private List<OrderItemDto> orderItems;
    @NotNull(message = "402")
    @NotEmpty(message = "402")
    private SalesOrderStatus status;
    private Double totalPrice;
}