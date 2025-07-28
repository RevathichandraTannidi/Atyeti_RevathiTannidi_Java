package com.parking.system.exceptionHandling;


public class InvalidRequestException extends Exception {
    public InvalidRequestException(String message) {
        super(message);
    }
}

