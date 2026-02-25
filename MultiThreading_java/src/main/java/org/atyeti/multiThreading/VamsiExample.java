package org.atyeti.multiThreading;

interface VamsiEngine
{
    void start();
}
class PetrolEngine implements VamsiEngine {
@Override
public void start() {
        System.out.println("Petrol Engine Started...");
    }
}


// Car class tightly coupled with PetrolEngine
class Car {

    // Direct object creation → Tight Coupling
    PetrolEngine engine ;

    public Car(PetrolEngine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is Driving...");
    }
}



// Main class
 public class VamsiExample {
    public static void main(String[] args) {

PetrolEngine v=new PetrolEngine();
        Car car = new Car(v);
        car.drive();
    }
}