package abstraction.e_commerce.paymentProcessing.paymentProcessing;

import abstraction.e_commerce.paymentProcessing.model.PaymentEvent;
import abstraction.e_commerce.paymentProcessing.model.PaymentRequest;
import abstraction.e_commerce.paymentProcessing.observer.PaymentObserver;
import abstraction.e_commerce.paymentProcessing.service.*;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    private List<PaymentObserver> observers = new ArrayList<>();

    public void registerObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PaymentObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(PaymentEvent event) {
        for (PaymentObserver observer : observers) {
            observer.update(event);
        }
    }

    public void processPayment(PaymentRequest request) {
        PaymentHandler validationHandler = new ValidationHandler();
        PaymentHandler fundsCheckHandler = new FundscheckHandler();
        PaymentHandler discountHandler = new DiscountHandler();
        PaymentHandler loggingHandler = new LoggingHandler();
        PaymentHandler notificationHandler = new NotificationHandler();

        validationHandler.setNextHandler(fundsCheckHandler);
        fundsCheckHandler.setNextHandler(discountHandler);
        discountHandler.setNextHandler(loggingHandler);
        loggingHandler.setNextHandler(notificationHandler);


        validationHandler.handle(request);


        PaymentEvent event = new PaymentEvent("PaymentProcessed", request);
        notifyObservers(event);
    }

}
