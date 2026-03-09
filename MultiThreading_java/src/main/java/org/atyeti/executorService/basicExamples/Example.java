package org.atyeti.executorService.basicExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++)
        {
            int task =i;
            ex.submit(()-> System.out.println("Task " +task + " with thread "+ Thread.currentThread().getName()));
        }
        ex.shutdown();
    }
}
