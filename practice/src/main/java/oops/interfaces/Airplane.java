package oops.interfaces;

public class Airplane implements Flyable {

    @Override
    public void fly() {
        System.out.println("The airplane accelerates on the runway and lifts into the sky!");
    }

}
