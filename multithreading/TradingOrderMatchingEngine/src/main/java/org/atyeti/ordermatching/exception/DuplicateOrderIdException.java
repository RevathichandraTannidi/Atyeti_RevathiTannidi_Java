package org.atyeti.ordermatching.exception;

public class DuplicateOrderIdException extends ValidationException {
    public DuplicateOrderIdException(String id) { super("Duplicate orderId: " + id); }
}
