package org.atyeti.java.foodDelivery;

public class OutputBased_1 {
    static int x = 10;
    public static void main(String[] args) {

        OutputBased_1 obj=new OutputBased_1();


        MyFunc f = () -> System.out.println(x);
        MyFunc f2=()-> System.out.println(obj.x);
        obj.x=20;
        f.test();
        f2.test();
    }

    @FunctionalInterface
    interface MyFunc {
        void test();
    }
}