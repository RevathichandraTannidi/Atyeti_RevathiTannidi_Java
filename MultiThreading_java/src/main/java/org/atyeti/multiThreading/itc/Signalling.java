package org.atyeti.multiThreading.itc;
class Signal {

    private boolean ready = false;

    public synchronized void waitForSignal() throws InterruptedException {

        while (!ready) {
            System.out.println("Waiting...");
            wait();
        }

        System.out.println("Received signal!");
    }

    public synchronized void sendSignal() {

        ready = true;
        System.out.println("Sending signal...");

        notify();
    }
}

public class Signalling {
    public static void main(String[] args) {

        Signal signal = new Signal();

        Thread t1 = new Thread(() -> {
            try {
                signal.waitForSignal();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                signal.sendSignal();
            } catch (Exception e) {}
        });

        t1.start();
        t2.start();
    }
}

