package org.atyeti.executorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(3);
        ex.submit(()-> System.out.println("Task 1 - " +Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 2 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 3 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 4 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 5 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 6 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 6 - "+Thread.currentThread().getName()));

        ex.submit(()-> System.out.println("Task 7 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 8 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 9 - "+Thread.currentThread().getName()));
        ex.submit(()-> System.out.println("Task 10 - "+Thread.currentThread().getName()));
        ex.shutdown();
    }
}
