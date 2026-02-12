package org.atyeti.multiThreading.threadclass;

public class CounterDemo {
    static class Counter {
        int count = 0; // shared mutable state

        void increment() {
            count++; // critical section
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int expected = 200_000;
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + counter.count);
    }
}