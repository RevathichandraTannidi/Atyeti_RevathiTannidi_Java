package abstraction.e_commerce.paymentProcessing.observer;

import abstraction.e_commerce.paymentProcessing.model.PaymentEvent;

public class ShippingNotificationObserver implements PaymentObserver{
    @Override
    public void update(PaymentEvent event) {
        System.out.println("shipping notification oserver for the event :"+event.getEventType());
    }
}
