package operators;

abstract class Vehicle {
    abstract void startEngine();
}

class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Starting the car engine");
    }
}

class Motorcycle extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Starting the motorcycle engine");
    }
}

public class InstanceofExample {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Car(), new Motorcycle()};

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                System.out.println("This is a Car.");
                vehicle.startEngine();
            } else if (vehicle instanceof Motorcycle) {
                System.out.println("This is a Motorcycle.");
                vehicle.startEngine();
            } else {
                System.out.println("This is a generic Vehicle.");
                vehicle.startEngine();
            }
        }
    }
}
