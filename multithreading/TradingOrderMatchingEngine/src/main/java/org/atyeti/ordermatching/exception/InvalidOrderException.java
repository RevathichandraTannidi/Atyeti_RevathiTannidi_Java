package org.atyeti.ordermatching.exception;

public class InvalidOrderException extends ValidationException {
    public InvalidOrderException(String msg) {
        super(msg);
    }
}
