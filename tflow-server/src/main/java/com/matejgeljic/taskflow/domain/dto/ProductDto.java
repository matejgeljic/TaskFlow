package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private UUID id;
    @NotBlank(message = "300")
    private String name;
    @NotBlank(message = "301")
    private String description;
    @NotNull(message = "302")
    @Min(value = 1, message = "303")
    private Double price;
    @NotNull(message = "304")
    @Min(value = 1, message = "305")
    private Double rating;
    @NotNull(message = "306")
    @Min(value = 1, message = "307")
    private Integer stockQuantity;
    @NotNull(message = "308")
    private Boolean isArchived;
}