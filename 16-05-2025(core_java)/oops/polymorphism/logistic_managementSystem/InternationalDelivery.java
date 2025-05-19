package polymorphism.logistic_managementSystem;

public class InternationalDelivery extends Delivery{
    @Override
    double calculateCost(double distance) {
        return 500 + 20 *distance + 100;
    }
}
