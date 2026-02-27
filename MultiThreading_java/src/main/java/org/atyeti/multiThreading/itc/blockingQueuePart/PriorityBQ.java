package org.atyeti.multiThreading.itc.blockingQueuePart;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBQ {
    public static void main(String[] args) throws InterruptedException {
   //     PriorityBlockingQueue<Integer> q = new PriorityBlockingQueue<>(11, Comparator.naturalOrder());
        PriorityBlockingQueue<Integer> q=new PriorityBlockingQueue<>(11,Comparator.reverseOrder());
//PriorityBlockingQueue<Integer> q=new PriorityBlockingQueue<>();
        q.put(30);
        q.put(10);
        q.put(20);
        q.put(3);
        System.out.println(q);
        System.out.println(q.take());
        System.out.println(q.take());
        System.out.println(q.take());
    }
}