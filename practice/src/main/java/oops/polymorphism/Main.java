package oops.polymorphism;



public class Main {
    public static void startVehicle (Vehicle v)
    {
v.start();
    }
    public static void main(String[] args) {
Car c=new Car();
startVehicle(c);
Bike b=new Bike();

startVehicle(b);
    }
}
