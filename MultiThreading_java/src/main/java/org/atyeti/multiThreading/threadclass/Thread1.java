package org.atyeti.multiThreading.threadclass;

public class Thread1 extends Thread {
    public void run()
    {
        for(int i=0;i<=5;i++)
        {
            System.out.println("Thread Running "+i );

        }
    }
}
class ThreadExample
{
    public static void main(String[] args) throws InterruptedException {
       Thread1 t1=new Thread1();
       t1.start();
       Thread1 t2= new Thread1();
       t2.start();

    }
}