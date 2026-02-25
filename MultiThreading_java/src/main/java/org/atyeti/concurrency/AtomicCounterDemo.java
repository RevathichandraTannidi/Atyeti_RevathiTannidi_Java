package org.atyeti.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterDemo {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();   // atomic ++
    }

    public int get() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCounterDemo demo = new AtomicCounterDemo();
        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) demo.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) demo.increment(); });
        t1.start(); t2.start(); t1.join(); t2.join();
        System.out.println("Final: " + demo.get());
    }
}