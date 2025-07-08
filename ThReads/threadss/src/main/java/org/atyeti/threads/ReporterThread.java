package org.atyeti.threads;

public class ReporterThread extends Thread {

    public void run() {
        setName("Reporter Thread");
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