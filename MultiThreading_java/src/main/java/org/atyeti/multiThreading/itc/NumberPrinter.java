package org.atyeti.multiThreading.itc;

public class NumberPrinter {
    private int number = 1;
    private final int limit;

    NumberPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() throws InterruptedException {
        while (number <= limit) {

            while (number % 2 == 0) {
                wait();
            }

            System.out.println("odd  : "+number + " ");
            number++;

            notifyAll();
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (number <= limit) {

            while (number % 2 == 1) {
                wait();
            }

            System.out.println("even : "+number + " ");
            number++;

            notifyAll();
        }
    }
}

 class Main1 {
    public static void main(String[] args) {

        NumberPrinter printer = new NumberPrinter(10);

        Thread odd = new Thread(() -> {
            try { printer.printOdd(); } catch (Exception e) {}
        });

        Thread even = new Thread(() -> {
            try { printer.printEven(); } catch (Exception e) {}
        });

        odd.start();
        even.start();
    }
}

