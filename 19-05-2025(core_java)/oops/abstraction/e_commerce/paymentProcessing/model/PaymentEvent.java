package abstraction.e_commerce.paymentProcessing.model;

public class PaymentEvent {
    private String eventType;
    private PaymentRequest paymentRequest;

    public PaymentEvent(String eventType, PaymentRequest paymentRequest) {
        this.eventType = eventType;
        this.paymentRequest = paymentRequest;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }
}
