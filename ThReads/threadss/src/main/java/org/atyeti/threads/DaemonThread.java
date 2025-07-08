package org.atyeti.threads;

public class DaemonThread {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Time: " + java.time.LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                    break;
                }
            }
        });


        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            System.out.println(" sleeping for 3 seconds");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("close test");
    }
}
