package com.matejgeljic.taskflow.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class TaskFlowException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final HttpStatus httpStatus;

    public TaskFlowException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
