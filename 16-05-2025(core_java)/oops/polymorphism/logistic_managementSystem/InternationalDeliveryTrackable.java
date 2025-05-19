package polymorphism.logistic_managementSystem;

public class InternationalDeliveryTrackable extends InternationalDelivery implements Trackable{
    @Override
    public String trackStatus() {
        return "International delivery: on The way";
    }
}
