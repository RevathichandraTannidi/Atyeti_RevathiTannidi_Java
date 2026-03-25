package org.atyeti.virtualThreads.waysToCreateVirtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewVirtualThreadPerTaskExecutor {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 5; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
                    try { Thread.sleep(500); } catch (InterruptedException e) {}
                });
            }

            System.out.println("All tasks submitted");
        }

        System.out.println("Executor terminated");
    }
}
