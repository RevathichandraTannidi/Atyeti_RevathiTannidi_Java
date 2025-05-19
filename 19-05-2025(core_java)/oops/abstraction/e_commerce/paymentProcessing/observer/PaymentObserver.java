package abstraction.e_commerce.paymentProcessing.observer;

import abstraction.e_commerce.paymentProcessing.model.PaymentEvent;

public interface PaymentObserver {
    void update(PaymentEvent event);
}
