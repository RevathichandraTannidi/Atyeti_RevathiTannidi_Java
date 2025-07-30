package org.atyeti.trafficManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadArgs(IllegalArgumentException ex) {
        return new ResponseEntity<>(new ErrorResponse(400, ex.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(500, "Internal error", LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

