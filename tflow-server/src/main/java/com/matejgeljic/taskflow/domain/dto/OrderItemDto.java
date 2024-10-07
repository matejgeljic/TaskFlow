package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private UUID id;
    @NotNull(message = "200")
    @Min(value = 1, message = "201")
    private Integer quantity;
    @NotNull(message = "202")
    private ProductDto product;
}