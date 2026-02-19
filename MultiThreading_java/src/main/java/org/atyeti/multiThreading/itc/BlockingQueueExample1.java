package org.atyeti.multiThreading.itc;


    import java.util.concurrent.*;

    public class BlockingQueueExample1 {
        public static void main(String[] args) throws InterruptedException {
            BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

            queue.put(1);  // adds element
            queue.put(2);
            queue.add(20);

            System.out.println(queue.take()); // removes element
            System.out.println(queue.take());
        }
    }


