package org.atyeti.executorService.basicExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleRunnable {
    public static void main(String[] args) {
        ExecutorService ser= Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i < 5; i++) {

                int finalI = i;
                Runnable task = () -> {
                    System.out.println("task " + finalI + " with thread number +" + Thread.currentThread().getName());
                };
                ser.submit(task);
            }
      ;

        }catch(Exception e){
            throw new RuntimeException(e);
        }
        finally {
            ser.shutdown();
        }
    }
}
