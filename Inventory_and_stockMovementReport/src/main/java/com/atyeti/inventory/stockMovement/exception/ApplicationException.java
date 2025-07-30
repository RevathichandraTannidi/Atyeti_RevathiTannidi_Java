package com.atyeti.inventory.stockMovement.exception;

public abstract class ApplicationException extends RuntimeException {
    private final ErrorCode errorCode;
    protected ApplicationException(ErrorCode code, String message) {
        super(message);
        this.errorCode = code;
    }
    public ErrorCode getErrorCode() { return errorCode; }
}
