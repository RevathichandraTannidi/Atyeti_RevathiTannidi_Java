package com.atyeti.inventory.stockMovement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Map<String, Object>> handleApplicationException(ApplicationException ex,
                                                                          HttpServletRequest req) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", ex.getErrorCode().getStatus());
        body.put("error", ex.getErrorCode().name());
        body.put("message", ex.getMessage());
        body.put("path", req.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex,
                                                                   HttpServletRequest req) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", ErrorCode.INTERNAL_ERROR.getStatus());
        body.put("error", ErrorCode.INTERNAL_ERROR.name());
        body.put("message", ex.getMessage());
        body.put("path", req.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
