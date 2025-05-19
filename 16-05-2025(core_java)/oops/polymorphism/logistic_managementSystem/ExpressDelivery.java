package polymorphism.logistic_managementSystem;

public class ExpressDelivery extends Delivery{
    @Override
    double calculateCost(double distance) {
        return 100+10*distance;
    }
}
