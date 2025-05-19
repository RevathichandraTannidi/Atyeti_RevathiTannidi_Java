package abstraction.e_commerce.paymentProcessing.observer;

import abstraction.e_commerce.paymentProcessing.model.PaymentEvent;

public class EmailNotificationObserver implements PaymentObserver{
    @Override
    public void update(PaymentEvent event) {
        System.out.println("email notification sent to the event:"+event.getEventType());
    }
}
