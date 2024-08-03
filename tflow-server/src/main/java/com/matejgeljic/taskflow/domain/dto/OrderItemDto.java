package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "200")
    private Integer quantity;
    @NotNull(message = "201")
    @NotEmpty(message = "201")
    private ProductDto product;
}