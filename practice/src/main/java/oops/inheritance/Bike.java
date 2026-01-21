package oops.inheritance;

class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("bike started");
    }

    void addWheel() {
        System.out.println("it has two wheels");
    }

    @Override
    void stop() {
        System.out.println("bike stopped");
    }
}
