package org.atyeti.multiThreading.itc.blockingQueuePart;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueue {

    public static void main(String[] args) {

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        // Thread 1 - Adding elements
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.add(i);
                System.out.println("Added: " + i);
            }
        });

        // Thread 2 - Removing elements
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                Integer value = queue.poll();   // returns null if empty
                System.out.println("Removed: " + value);
            }
        });

        producer.start();
        consumer.start();
    }
}
