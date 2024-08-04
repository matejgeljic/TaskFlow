package com.matejgeljic.taskflow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskFlowException.class)
    public ResponseEntity<ErrorResponse> handleNotEnoughStockException(TaskFlowException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        );

        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = "Validation error occurred";

        Optional<FieldError> fieldError = ex.getBindingResult().getFieldErrors().stream().findFirst();
        if (fieldError.isPresent()) {
            errorMessage = fieldError.get().getDefaultMessage();
        }

        ErrorResponse errorResponse = new ErrorResponse(
                errorMessage,
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
