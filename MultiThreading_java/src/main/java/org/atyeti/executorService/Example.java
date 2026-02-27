package org.atyeti.executorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(3);
        ex.submit(()-> System.out.println("Task 1"));
        ex.submit(()-> System.out.println("Task 2"));
        ex.submit(()-> System.out.println("Task 3"));
        ex.submit(()-> System.out.println("Task 4"));
        ex.submit(()-> System.out.println("Task 5"));
        ex.submit(()-> System.out.println("Task 6"));
        ex.shutdown();
    }
}
