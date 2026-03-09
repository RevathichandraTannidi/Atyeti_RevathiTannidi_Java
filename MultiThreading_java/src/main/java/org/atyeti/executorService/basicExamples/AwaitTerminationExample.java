package org.atyeti.executorService.basicExamples;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationExample {
    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(3);
        Random r=new Random();
     try
     {
         for(int i=0;i<3;i++) {
             int random = r.nextInt(500) + 300;
             int finalI = i;
             ex.submit(()->
             {
                 try
                 {
                     System.out.println("task "+ finalI +"thread num"+ Thread.currentThread().getName());
                     Thread.sleep(random);
                     System.out.println("task "+finalI+"completed");
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             });
         }

         System.out.println("started the shutdown ");
         ex.shutdown();
         // Wait max 2 seconds for all tasks to complete
         boolean completed = ex.awaitTermination(2, TimeUnit.SECONDS);

         // Print result
         if (completed) {
             System.out.println("\n All tasks completed within 2 seconds!");
         } else {
             System.out.println("\nTimeout! Some tasks did not complete in 2 seconds.");
             System.out.println("Forcing shutdown...");
             ex.shutdownNow();  // Force interrupt running tasks
         }

     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted!");
         Thread.currentThread().interrupt();
         ex.shutdownNow();
     }


    }
}
