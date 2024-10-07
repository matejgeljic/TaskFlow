package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrderStatusUpdateDto {
    @NotNull(message = "500")
    private SalesOrderStatus status;
}
