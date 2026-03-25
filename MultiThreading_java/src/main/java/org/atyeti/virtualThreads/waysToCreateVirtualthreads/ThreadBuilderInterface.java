package org.atyeti.virtualThreads.waysToCreateVirtualthreads;

public class ThreadBuilderInterface {
    public static void main(String[] args) {
        try
        {
            Thread.Builder builder=Thread.ofVirtual().name("virtualThread 1");

            Runnable r=()->{
                System.out.println("running thread");
            };
            Thread t= builder.start(r);
            System.out.println("Thread t name :"+ t.getName());
        Thread.sleep(1000);
        t.join();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
