package com.matejgeljic.taskflow.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesOrderStatusUpdateDto {
    @NotNull(message = "500")
    private SalesOrderStatus status;
}
