package abstraction.e_commerce.paymentProcessing.service;

import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;

public abstract class PaymentHandler {
    protected PaymentHandler nextHandler;

    public void setNextHandler(PaymentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handle(PaymentRequest request);
}
