package org.atyeti.virtualThreads.waysToCreateVirtualthreads;

public class ThreadOFVirtual {
    public static void main(String[] args) throws InterruptedException {
        Thread vThread = Thread.ofVirtual()
                .name("worker-thread-", 1)
                .uncaughtExceptionHandler((t, e) -> {
                    System.out.println("Error in " + t.getName() + ": " + e);
                })
                .start(() -> {
                    System.out.println("Working on: " + Thread.currentThread().getName());
                });

        vThread.join();
    }
}