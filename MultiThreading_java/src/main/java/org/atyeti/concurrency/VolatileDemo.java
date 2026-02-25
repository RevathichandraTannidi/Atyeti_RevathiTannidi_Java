package org.atyeti.concurrency;

class VolatileDemo {
    private static volatile boolean done = false;

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            System.out.println("Thread1 running...");
            try {
                Thread.sleep(2000);
            } catch (Exception ignored) {}
            done = true;
            System.out.println("Thread1 set done = true");
        }).start();

        new Thread(() -> {
            System.out.println("Thread2 waiting...");
            while (!done) { }
            System.out.println("Thread2 detected done = true");
        }).start();
    }
}