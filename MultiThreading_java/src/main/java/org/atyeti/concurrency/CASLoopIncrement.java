package org.atyeti.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class CASLoopIncrement {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        while (true) {
            int current = counter.get();
            int next = current + 1;
            if (counter.compareAndSet(current, next)) {
                return;
            }
            Thread.onSpinWait();
            // else: someone updated it → retry with fresh value
        }
    }

    public int get() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        CASLoopIncrement demo = new CASLoopIncrement();

        Thread t1 = new Thread(() -> { for (int i = 0; i < 100; i++) demo.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 100; i++) demo.increment(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final: " + demo.get());
    }
}