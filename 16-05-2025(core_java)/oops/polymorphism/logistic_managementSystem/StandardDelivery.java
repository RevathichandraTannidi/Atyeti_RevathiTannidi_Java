package polymorphism.logistic_managementSystem;

public class StandardDelivery extends  Delivery {


    @Override
    double calculateCost(double distance) {
        return 50+5*distance;
    }
}
