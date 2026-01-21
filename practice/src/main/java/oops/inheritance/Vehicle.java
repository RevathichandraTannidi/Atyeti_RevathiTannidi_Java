package oops.inheritance;
//Practice:
//Vehicle (parent) → Car, Bike (children).
//Vehicle has start(), stop().
//Car adds openTrunk(), Bike adds wheelie().
public class Vehicle {

    void start()
    {
        System.out.println("started the vehicle");
    }
    void stop()
    {
        System.out.println("stooped the vehicle");
    }
}

