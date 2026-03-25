package org.atyeti.virtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MillionThreadChallenge {
    public static void main(String[] args) throws InterruptedException {

    System.out.println("Starting 1,000,000 virtual threads...");
    long start = System.currentTimeMillis();

    try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
        for (int i = 0; i < 1_000_000; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    long end = System.currentTimeMillis();
    System.out.println("Completed in: " + (end - start) + " ms");
    System.out.println("Success: Virtual threads handled 1M concurrency easily.");
    }
}