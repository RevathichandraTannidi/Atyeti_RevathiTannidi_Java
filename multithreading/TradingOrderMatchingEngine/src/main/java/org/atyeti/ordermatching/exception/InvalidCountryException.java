package org.atyeti.ordermatching.exception;

public class InvalidCountryException extends ValidationException {
    public InvalidCountryException(String cc) {
        super("Invalid country: " + cc);
    }
}
