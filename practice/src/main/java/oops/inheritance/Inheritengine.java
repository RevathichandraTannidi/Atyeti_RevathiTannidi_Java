package oops.inheritance;

public class Inheritengine {
    public static void main(String[] args) {
       Car cr= new Car();
        Vehicle vh=new Vehicle();
  Bike bk=new Bike();
        vh.start();vh.stop();
        cr.start();cr.stop();cr.openTrunk();
        bk.start();bk.stop();bk.addWheel();
    }



}
