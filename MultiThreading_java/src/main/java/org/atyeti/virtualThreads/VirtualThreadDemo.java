package org.atyeti.virtualThreads;

public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
     Thread vt=  Thread.startVirtualThread(()->{
            System.out.println("hi im virtual thread");
        });
        vt.join();
        System.out.println("normal thread");
    }
}
