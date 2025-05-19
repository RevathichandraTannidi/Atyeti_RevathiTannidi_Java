package polymorphism.logistic_managementSystem;

public class StandardDeliveryTrackable extends StandardDelivery implements Trackable{
    @Override
    public String trackStatus() {
        return "Standard Delivery: In Transit";
    }
}
