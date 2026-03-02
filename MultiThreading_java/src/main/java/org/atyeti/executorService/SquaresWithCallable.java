package org.atyeti.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SquaresWithCallable {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            List<Future<Integer>> futures = new ArrayList<>();

            for (int i = 1; i <= 5; i++) {
                final int num = i;
                Callable<Integer> task = () -> {

                    TimeUnit.MILLISECONDS.sleep(200);
                    return num * num;
                };
                futures.add(executor.submit(task));
            }

            for (int i = 0; i < futures.size(); i++) {
                try {
                    Integer square = futures.get(i).get();
                    System.out.println("Result " + (i + 1) + ": " + square);
                } catch (ExecutionException e) {
                    System.err.println("Task failed: " + e.getCause());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Interrupted while waiting for result");
                }
            }
        } finally {

            executor.shutdown();
        }
    }
}