package org.atyeti.multiThreading.itc;

public class ThreadBarrier {
    private static final Object lock = new Object();
    private static int reachedCount = 0;
    private static final int TOTAL_THREADS = 3;
    private static boolean allReady = false;

    public static void main(String[] args) {
        Thread[] threads = new Thread[TOTAL_THREADS];
        for (int i = 0; i < TOTAL_THREADS; i++) {
            final int id = i + 1;
            threads[i] = new Thread(() -> {
                synchronized (lock) {
                    System.out.println("Thread " + id + " reached");
                    reachedCount++;
                    if (reachedCount == TOTAL_THREADS) {
                        allReady = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                System.out.println("Thread " + id + " proceeding → all reached!");
            });
            threads[i].start();
        }
    }
}

