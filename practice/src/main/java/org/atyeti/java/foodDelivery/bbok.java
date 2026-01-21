package org.atyeti.java.foodDelivery;

//public interface bbok {
//    void name();
//default  void foo(){
//    System.out.print("im defaukt");
//    foo1();
//}
//private void foo1(){
//    System.out.print("im private");
//}
//static void fo2(){
//
//    System.out.print("im static");
//}
//}
//class b implements bbok
//{
//
//    @Override
//    public void name() {
//        System.out.print("revathi");
//    }
////
////    @Override
////    public void foo() {
////        bbok.super.foo();
////    }
//
//
//    public static void main(String[] args) {
//        b b=new b();
//       b.foo();
//       b.name();
//       bbok.fo2();
//
//    }
//}


//Super class
class Vehicle {
    Vehicle() {
        System.out.println("This is a Vehicle");
    }
}

// Subclass
class Car extends Vehicle {
    Car() {
        System.out.println("This Vehicle is Car");
    }


}

class  Bike extends Car{
    Bike()
    {
        System.out.println("This vehicle is bike");
    }
}
 class Test2 {
    public static void main(String[] args) {
        // Creating object of subclass invokes base class constructor
       Bike obj = new Bike();


    }
}