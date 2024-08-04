package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    @NotNull(message = "300")
    @NotEmpty(message = "300")
    private String name;
    @NotNull(message = "301")
    @NotEmpty(message = "301")
    private String description;
    @NotNull(message = "302")
    @NotEmpty(message = "302")
    private Double price;
    @NotNull(message = "303")
    @NotEmpty(message = "303")
    private Double rating;
    @NotNull(message = "304")
    @NotEmpty(message = "304")
    private Integer stockQuantity;
    @NotNull(message = "305")
    @NotEmpty(message = "305")
    private Boolean isArchived;
}