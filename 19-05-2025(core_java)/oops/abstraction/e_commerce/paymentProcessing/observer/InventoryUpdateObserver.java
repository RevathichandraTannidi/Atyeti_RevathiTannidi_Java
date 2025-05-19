package abstraction.e_commerce.paymentProcessing.observer;

import abstraction.e_commerce.paymentProcessing.model.PaymentEvent;

public class InventoryUpdateObserver implements PaymentObserver{
    @Override
    public void update(PaymentEvent event) {
        System.out.println("inventory update for the event:"+event.getEventType());
    }
}
