package polymorphism.logistic_managementSystem;

public class Main {
    public static void main(String[] args) {
        Delivery[] deliveries = {
                new StandardDelivery(),
                new ExpressDelivery(),
                new InternationalDelivery()
        };

        double[] distances = {10, 20, 30};

        System.out.println(" Delivery Costs ");
        for (int i = 0; i < deliveries.length; i++) {
            System.out.println("Cost: ₹" + deliveries[i].calculateCost(distances[i]));
        }

        Trackable[] trackables = {
                new StandardDeliveryTrackable(),
                new ExpressDeliveryTrackable(),
                new InternationalDeliveryTrackable()
        };

        System.out.println("\n Tracking Status ");
        for (Trackable t : trackables) {
            System.out.println(t.trackStatus());
        }
    }
}
