package org.atyeti.ordermatching.exception;

public class AmountLimitExceededException extends ValidationException {
    public AmountLimitExceededException(String msg) {
        super(msg);
    }
}
