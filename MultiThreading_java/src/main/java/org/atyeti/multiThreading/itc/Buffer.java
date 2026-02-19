package org.atyeti.multiThreading.itc;

public class Buffer {
    private int data;
    private boolean hasData=false;
    public synchronized void produce(int value) throws InterruptedException {

        // wait if buffer full
        while (hasData) {
            wait();
        }

        data = value;
        hasData = true;
        System.out.println("Produced: " + value);

        notify();   // wake consumer
    }
    public synchronized void consume() throws InterruptedException {

        // wait if buffer empty
        while (!hasData) {
            wait();
        }

        System.out.println("Consumed: " + data);
        hasData = false;

        notify();   // wake producer
    }
}
class Producer extends Thread
{
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("exception "+e);
        }
    }
    }
class Consumer extends Thread {
    private Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            System.out.println(" exception  c"+e);
        }
    }
}
class Main
{
    public static void main(String[] args) {
        Buffer b=new Buffer();
        Producer p=new Producer(b);
        Consumer c=new Consumer(b);
        p.start();
        c.start();
    }
}