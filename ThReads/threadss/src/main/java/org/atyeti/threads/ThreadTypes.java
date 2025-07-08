package org.atyeti.threads;

import java.util.concurrent.*;

public class ThreadTypes {
    public static void main(String[] args) {

        Thread th = new Thread(() -> {
            System.out.println("Thread using lambda expression");
        });
        th.start();

        ExecutorService exe = Executors.newSingleThreadExecutor();

        Callable<Integer> call = () -> {
            System.out.println("Callable is running ");
            return 42;
        };

        Future<Integer> future = exe.submit(call);

        try {
            Integer result = future.get();
             System.out.println("callable: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            exe.shutdown();
        }
    }
}
