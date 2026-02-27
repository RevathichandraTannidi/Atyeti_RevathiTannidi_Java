package org.atyeti.multiThreading.itc.blockingQueuePart;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockIngQueueChecks {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        queue.put(1);
        queue.put(2);
        queue.take();
     //   System.out.println("Removed: " + queue.take());  // take first
        queue.put(90);                                   // then put

        System.out.println(queue);
    }
}
