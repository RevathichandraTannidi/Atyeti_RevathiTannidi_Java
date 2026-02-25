package org.atyeti.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionDemo
{
    private static int count=0;
   // private  static final AtomicInteger count =new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        int threads = 10;
        int incrementsPerThread = 10000;
        Thread[] workers = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    // Not atomic: read-modify-write
                  //  count.incrementAndGet();
                    count++;

                }
            });
            workers[i].start();
        }

        for (Thread t : workers) t.join();

        System.out.println("Expected: " + (threads * incrementsPerThread));
        System.out.println("Actual  : " + count);
    }


}
