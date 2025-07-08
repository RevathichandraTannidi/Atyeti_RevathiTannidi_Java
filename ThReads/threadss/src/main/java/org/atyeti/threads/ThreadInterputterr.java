package org.atyeti.threads;

public class ThreadInterputterr {

    public static void main(String[] args) {

        Thread sT = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("sleeping for 200ms ");
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                System.out.println("  InterruptedException!");
        System.out.println("isInterrupted(): " + Thread.currentThread().isInterrupted());
            System.out.println("interrupted(): " + Thread.interrupted());
        System.out.println(" interrupted() again: " + Thread.interrupted());

                System.out.println("thread.sleep.close");
            }
        });



        Thread iT = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println(" Interrupting");
                sT.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        sT.start();
        iT.start();
    }
}
