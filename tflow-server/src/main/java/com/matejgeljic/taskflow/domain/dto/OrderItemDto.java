package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
    private Long id;
    @NotNull(message = "200")
    @Min(value = 1, message = "201")
    private Integer quantity;
    @NotNull(message = "202")
    private ProductDto product;
}