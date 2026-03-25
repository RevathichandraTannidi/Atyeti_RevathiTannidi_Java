package org.atyeti.virtualThreads;

public class PinningCheck {
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting virtual thread with synchronized block...");

        Thread vt = Thread.startVirtualThread(() -> {

            synchronized (lock) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
            }
        });

        vt.join();
        System.out.println("Finished.");
    }
}
