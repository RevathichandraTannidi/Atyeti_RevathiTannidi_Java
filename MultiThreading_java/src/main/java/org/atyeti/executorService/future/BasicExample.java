package org.atyeti.executorService.future;

import java.util.concurrent.*;

public class BasicExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit a Callable task that returns a result
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000);
            return 42;
        });

        try {
            System.out.println("Task submitted. Doing other work...");


            while (!future.isDone()) {
                System.out.println("Task not done yet...");
                Thread.sleep(500);
            }

            // Retrieve the result (blocks if not ready)
            Integer result = future.get();
            System.out.println("Result: " + result);

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted.");
        } catch (ExecutionException e) {
            System.err.println("Task threw an exception: " + e.getCause());
        } finally {
            executor.shutdown();
        }
    }
}

