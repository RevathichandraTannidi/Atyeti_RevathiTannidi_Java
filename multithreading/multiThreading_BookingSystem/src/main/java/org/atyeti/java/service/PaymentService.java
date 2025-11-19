package org.atyeti.java.service;


import org.atyeti.java.model.PaymentResult;

import java.util.Random;

public class PaymentService {

    public PaymentResult processPayment(double amount) {
        Random r = new Random();

        boolean success = r.nextBoolean();

        if (success) {
            return new PaymentResult(true, "Payment of " + amount + " processed successfully.");
        }
        return new PaymentResult(false, "Payment FAILED Please try again.");
    }
}
