package org.atyeti.java.foodDelivery;

class MyTask extends Thread {
    public void run() {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
    }
}

public class Test {
    public static void main(String[] args) {
        MyTask t = new MyTask();
        t.run();
        t.start();
    }
}