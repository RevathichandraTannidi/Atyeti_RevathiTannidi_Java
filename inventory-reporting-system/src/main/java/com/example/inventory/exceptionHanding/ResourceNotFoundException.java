package com.example.inventory.exceptionHanding;

public class    ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
