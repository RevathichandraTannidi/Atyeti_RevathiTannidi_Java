package org.atyeti.multiThreading.threadclass;

class VisibilityDemo {
    static volatile boolean running = false;

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            while (running) {
            }
            System.out.println("Stopped");
        });

        t.start();
        Thread.sleep(1000);
        running = true;
    }
}