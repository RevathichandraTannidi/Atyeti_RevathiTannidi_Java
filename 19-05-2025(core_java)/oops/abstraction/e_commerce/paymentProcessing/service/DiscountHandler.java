package abstraction.e_commerce.paymentProcessing.service;

import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;

public class DiscountHandler extends PaymentHandler{
    @Override
    public void handle(PaymentRequest request) {
        System.out.println("Discount applied");
        if(nextHandler!=null)
        {
            nextHandler.handle(request);
        }
    }
}
