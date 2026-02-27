package org.atyeti.multiThreading.itc.blockingQueuePart;
import java.util.concurrent.*;

public class LinkedBQ {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> q = new LinkedBlockingQueue<>(); // effectively very large
        q.put("P1");
        q.put("P2");
        q.put("P3");
        q.put("P3");
        q.put("P4");
        q.put("P5");
        q.put("P6");
        q.put("P7");
        q.put("P8");
        q.put("P9");
        System.out.println("Size: " + q.size());

        System.out.println(q.take()); // P1
        System.out.println(q.take()); // P2
        System.out.println(q.take()); // P3
        System.out.println(q);
    }
}