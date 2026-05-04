package org.atyeti.finance_analytical_system.exception;


public class FinancialException extends RuntimeException {

    public FinancialException(String message) {
        super(message);
    }

    public FinancialException(String message, Throwable cause) {
        super(message, cause);
    }
}