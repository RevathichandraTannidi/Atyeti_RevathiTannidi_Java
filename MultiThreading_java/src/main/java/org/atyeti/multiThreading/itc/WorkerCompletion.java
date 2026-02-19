package org.atyeti.multiThreading.itc;

public class WorkerCompletion {
    private static final Object lock = new Object();
    private static boolean jobDone = false;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Worker processing job...");
                try {
                    lock.wait(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                jobDone = true;
                System.out.println("Worker job completed");
                lock.notify();
            }
        });

        synchronized (lock) {
            worker.start();
            lock.notify();
            while (!jobDone) {
                lock.wait();
            }
        }
        System.out.println("Main: Worker finished, continuing");
    }
}
