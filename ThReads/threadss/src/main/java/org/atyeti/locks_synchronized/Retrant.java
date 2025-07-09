package org.atyeti.locks_synchronized;

public class Retrant {
    public static void main(String[] args) throws InterruptedException {
         Counter1 count = new Counter1();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                count.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                 count.increment();
        });

        t1.start();
         t2.start();
        t1.join();
        t2.join();

        System.out.println("count :" + count.getCount());
    }
}