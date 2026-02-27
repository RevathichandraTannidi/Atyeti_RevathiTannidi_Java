package org.atyeti.multiThreading.itc.blockingQueuePart;


    import java.util.concurrent.*;

    public class BlockingQueueExample1 {
        public static void main(String[] args) throws InterruptedException {
            BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

           queue.put(1);
          queue.put(2);


 new Thread(()->{
     try {
         queue.take();
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
 }).start();
            queue.put(90);

            System.out.println(queue);

        }
    }


