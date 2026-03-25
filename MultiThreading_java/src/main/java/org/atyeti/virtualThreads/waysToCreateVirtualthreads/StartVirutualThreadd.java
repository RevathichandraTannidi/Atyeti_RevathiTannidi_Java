package org.atyeti.virtualThreads.waysToCreateVirtualthreads;

public class StartVirutualThreadd {
           public static void main(String[] args) throws InterruptedException {

            Thread vThread = Thread.startVirtualThread(() -> {
                System.out.println("Running inside: " + Thread.currentThread().getName());
                System.out.println("Is Virtual: " + Thread.currentThread().isVirtual());
            });

            vThread.join();
            System.out.println("Main thread finished");
        }
    }



