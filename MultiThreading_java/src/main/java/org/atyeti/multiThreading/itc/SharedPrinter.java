package org.atyeti.multiThreading.itc;

public class SharedPrinter {
    private static final Object lock = new Object();
    private static boolean aTurn = true;
    private static boolean printing = false;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> print("Thread A", true));
        Thread threadB = new Thread(() -> print("Thread B", false));
        threadA.start();
        threadB.start();
    }

    private static void print(String name, boolean isA) {
        for (int i = 0; i < 3; i++) {
            synchronized (lock) {
                while (printing || (isA != aTurn)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                printing = true;
                System.out.println(name + " printing page " + (i + 1));
                printing = false;
                aTurn = !aTurn;
                lock.notifyAll();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

