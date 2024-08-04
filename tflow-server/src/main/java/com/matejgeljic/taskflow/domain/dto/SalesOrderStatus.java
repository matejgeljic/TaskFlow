package com.matejgeljic.taskflow.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SalesOrderStatus {
    AWAITING_PAYMENT("AwaitingPayment"),
    PAID("Paid"),
    CANCELLED("Cancelled");

    private final String value;

    SalesOrderStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static SalesOrderStatus fromValue(String value) {
        for (SalesOrderStatus b : SalesOrderStatus.values()) {
            if (b.value.equalsIgnoreCase(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
