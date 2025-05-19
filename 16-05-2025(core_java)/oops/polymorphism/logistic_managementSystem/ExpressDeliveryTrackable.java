package polymorphism.logistic_managementSystem;

public class ExpressDeliveryTrackable extends ExpressDelivery implements Trackable{
    @Override
    public String trackStatus() {
        return "Express Delivery: Reached to nearest hub";
    }
}
