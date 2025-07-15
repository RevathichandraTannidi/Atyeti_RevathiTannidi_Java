package org.atyeti.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executee {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> System.out.println("Task 1"));
        executor.execute(() -> System.out.println("Task 2"));

        executor.shutdown();

    }
}

