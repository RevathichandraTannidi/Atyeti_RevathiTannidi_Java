package abstraction.e_commerce.paymentProcessing.service;

import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;

public class LoggingHandler extends PaymentHandler{
    @Override
    public void handle(PaymentRequest request) {
        System.out.println("transaction logged the data by the transaction id :"+request.getTransactionId());
        if(nextHandler!=null)
        {
            nextHandler.handle(request);
        }
    }
}
