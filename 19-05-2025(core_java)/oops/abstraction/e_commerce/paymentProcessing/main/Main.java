package abstraction.e_commerce.paymentProcessing.main;

import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;
import abstraction.e_commerce.paymentProcessing.observer.EmailNotificationObserver;
import abstraction.e_commerce.paymentProcessing.observer.InventoryUpdateObserver;
import abstraction.e_commerce.paymentProcessing.observer.ShippingNotificationObserver;
import abstraction.e_commerce.paymentProcessing.paymentProcessing.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Register observers
        processor.registerObserver(new EmailNotificationObserver());
        processor.registerObserver(new InventoryUpdateObserver());
        processor.registerObserver(new ShippingNotificationObserver());

        PaymentRequest request = new PaymentRequest();
        request.setTransactionId("TXN12345");
        request.setAmount(100.0);
        request.setCurrency("USD");
        request.setPaymentMethod("CreditCard");
        request.setPaymentStatus("Pending");
        request.setUserId("User001");
        request.setAccountId("Account001");
        request.setBillingAddress("123 Main St");
        request.setTokenizedCardNumber("**** **** **** 1234");
        request.setCvv("123");
        request.setExpiryDate("12/25");

        processor.processPayment(request);
    }
}
