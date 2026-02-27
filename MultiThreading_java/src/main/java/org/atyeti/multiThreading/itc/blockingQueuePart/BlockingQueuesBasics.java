package org.atyeti.multiThreading.itc.blockingQueuePart;

import java.util.concurrent.*;

public class BlockingQueuesBasics {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);

        new Thread(() -> { // Producer
            try {
                q.put(1); // ok
                q.put(2); // ok
                q.put(3); // waits until consumer takes one
                System.out.println("Produced 3 items");
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }).start();

        new Thread(() -> { // Consumer
            try {
                System.out.println(q);
                Thread.sleep(1000);
                System.out.println("Took: " + q.take());
                System.out.println(q);
                Thread.sleep(1000);
                System.out.println("Took: " + q.take());
                System.out.println(q);
                Thread.sleep(1000);
                System.out.println("Took: " + q.take());
                System.out.println(q);
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }).start();
    }
}