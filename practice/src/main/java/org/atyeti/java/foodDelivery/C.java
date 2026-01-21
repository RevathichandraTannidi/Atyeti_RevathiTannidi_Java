package org.atyeti.java.foodDelivery;

interface A {
    void show();
}

interface B {
 void show1();
}

class C implements A, B {


    @Override
    public void show() {
        System.out.println("rev");
    }


    @Override
    public void show1() {
        System.out.println("b");
    }
}
class Test3
{
    public static void main(String[] args) {
        C a=new C();
        a.show();
        a.show1();
    }
}