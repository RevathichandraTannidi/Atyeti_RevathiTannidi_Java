package org.atyeti.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCAS {
    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(10);

        int expected = 10;   // what we believe is in memory
        int update   = 20;   // new value we want to set

        boolean ok = atomic.compareAndSet(expected, update);

        System.out.println("CAS success? " + ok);
        System.out.println("Current value: " + atomic.get());
    }
}