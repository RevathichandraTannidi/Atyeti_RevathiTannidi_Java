package abstraction.e_commerce.paymentProcessing.service;

import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;

public class FundscheckHandler  extends PaymentHandler{

    @Override
    public void handle(PaymentRequest request) {
     boolean   hassufficentFunds=true;
     if(hassufficentFunds) {
         System.out.println("sufficient funds available");

         if (nextHandler != null) {
             nextHandler.handle(request);
         }
     }else {
         System.out.println(" insufficient funds");
     }

    }
}
