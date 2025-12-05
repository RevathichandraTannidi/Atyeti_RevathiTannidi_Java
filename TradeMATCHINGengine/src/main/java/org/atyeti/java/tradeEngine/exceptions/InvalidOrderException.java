package org.atyeti.java.tradeEngine.exceptions;


public class InvalidOrderException extends ValidationException {
    public InvalidOrderException(String msg) {
        super(msg);
    }
}
