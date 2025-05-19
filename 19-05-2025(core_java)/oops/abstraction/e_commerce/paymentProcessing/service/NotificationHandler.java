package abstraction.e_commerce.paymentProcessing.service;

import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;

public class NotificationHandler extends PaymentHandler{
    @Override
    public void handle(PaymentRequest request) {
        System.out.println("Notification logged for transaction id :"+request.getTransactionId());
        if(nextHandler!=null)
        {
            nextHandler.handle(request);
        }
    }
}
