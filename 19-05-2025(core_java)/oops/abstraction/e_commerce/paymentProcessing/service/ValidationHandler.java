package abstraction.e_commerce.paymentProcessing.service;

import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;

public class ValidationHandler extends PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {
        if(request.getAmount()>0 && request.getCurrency()!=null)
        {
            System.out.println("validation passed");
            if(nextHandler!=null)
            {
                nextHandler.handle(request);
            }
        }
        else {
            System.out.println("validation failed");
        }
    }
}
