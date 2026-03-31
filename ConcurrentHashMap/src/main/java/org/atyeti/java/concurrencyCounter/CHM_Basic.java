package org.atyeti.java.concurrencyCounter;

import java.util.concurrent.ConcurrentHashMap;

public class CHM_Basic {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        Runnable writer = () -> {
            for (int i = 0; i < 10; i++) {
                map.put(i, "Thread-" + Thread.currentThread().getId() + "-Value" + i);
            }
        };
        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(writer);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Map size: " + map.size()); // Always 10 (not 20)
        System.out.println("Sample value: " + map.get(5));
    }
}
