package org.atyeti.multiThreading.itc;

class DataBox {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {

        data = value;
        available = true;

        System.out.println("Produced: " + value);

        notify();
    }

    public synchronized void consume() throws InterruptedException {

        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + data);
    }

    public static void main(String[] args) throws InterruptedException {
        DataBox db=new DataBox();

        db.produce(9);
        db.consume();

    }
}
