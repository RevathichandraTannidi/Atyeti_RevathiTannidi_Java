package org.atyeti.threads;
public class EvenOddPrinter {

    private final int max;
     private int num = 1;
    private final Object lock = new Object();

    public EvenOddPrinter(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (lock) {
            while (num <= max) {
            while (num % 2 == 0) {
                    try {
                         lock.wait();
                    } catch (InterruptedException e) {
                         Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println("Odd: " + num);
                num++;
                lock.notify();
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (num <= max) {
                while (num % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println("Even: " + num);
                num++;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter(10);

        Thread oddThread = new Thread(printer::printOdd, "Odd Thread");
        Thread evenThread = new Thread(printer::printEven, "Even Thread");

        oddThread.start();
        evenThread.start();
    }
}

