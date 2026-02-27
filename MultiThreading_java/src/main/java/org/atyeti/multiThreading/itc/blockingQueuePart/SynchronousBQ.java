package org.atyeti.multiThreading.itc.blockingQueuePart;

import java.util.concurrent.*;

public class SynchronousBQ {
    public static void main(String[] args) throws Exception {
        SynchronousQueue<String> q = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("Consumer ready...");
                System.out.println("Took: " + q.take()); // takes when producer offers
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }).start();

        System.out.println("Producer offering X (will wait)...");
        q.put("X"); // waits until consumer takes
        System.out.println("Delivered X");
    }
}
