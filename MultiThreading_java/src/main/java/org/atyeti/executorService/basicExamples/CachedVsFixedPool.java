package org.atyeti.executorService.basicExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedVsFixedPool {
    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(2);
        ExecutorService  ex2=Executors.newCachedThreadPool();
        for(int i=0;i<10;i++)
        {
            int task =i;
            ex.submit(()-> System.out.println("Task " +task + " with new fixed thread pool "+ Thread.currentThread().getName()));
        }
        for(int i=0;i<10;i++)
        {
            int task =i;
            ex2.submit(()-> System.out.println("Task " +task + " with thread new cached thread pool"+ Thread.currentThread().getName()));
        }
        ex.shutdown();
        ex2.shutdown();

    }
}



