package org.atyeti.virtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualVsPlatform {
    static void simulateTask() throws InterruptedException {
        Thread.sleep(1000);
    }

    static void runTest(String name, ExecutorService executor) throws Exception {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                try {
                    simulateTask();
                } catch (InterruptedException e) {}
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);

        long end = System.currentTimeMillis();
        System.out.println(name + " took: " + (end - start) + " ms");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--- Running Platform Threads (Fixed Pool of 10) ---");
           runTest("Platform  ", Executors.newFixedThreadPool(10));

       System.out.println("\n--- Running Virtual Threads ---");

        runTest("Virtual   ", Executors.newVirtualThreadPerTaskExecutor());
    }
}