package org.atyeti.ordermatching.exception;

public class InsufficientQuantityException extends Exception {
    public InsufficientQuantityException(String msg) {
        super(msg);
    }
}
