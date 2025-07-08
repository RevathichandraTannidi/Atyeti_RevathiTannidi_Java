package org.atyeti.threads;

public class CollectorThread extends Thread {


    public void run() {
        setName("CollectorThread");
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(getName() + " - Iteration " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted during sleep.");
                return;
            }

        }
    }
}
