package org.atyeti.virtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MillionThreads {
    public static void main(String[] args) throws InterruptedException {

        // Use Virtual Threads
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            long start = System.currentTimeMillis();

            for (int i = 0; i < 1_000_000; i++) {
                executor.submit(() -> {
                    try { Thread.sleep(1000); } catch (InterruptedException e) {}
                    return null;
                });
            }

            // Shutdown and wait
            executor.shutdown();
            executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);

            long end = System.currentTimeMillis();
            System.out.println("Completed in: " + (end - start) + " ms");
        }
    }
}
