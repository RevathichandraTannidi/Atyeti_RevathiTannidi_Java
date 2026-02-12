package org.atyeti.multiThreading;

public class MyRunnable  implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName()+"-"+i);
        }
    }

}
class ThreadRunnable
{
    public static void main(String[] args) throws InterruptedException {
//        MyRunnable r=new MyRunnable();
//        Thread t=new Thread(r);
//        t.start();
//       Thread h=new Thread(new MyRunnable());
//       h.start();
//        Thread b=new Thread(new MyRunnable());
//        b.start();
//        h.join();
//       b.join();
//        System.out.println("ENd");
        Thread t1= new Thread(()->
        {
            System.out.println("task1 is running");
        });
        Thread t2= new Thread(()->
        {
            System.out.println("task 2 is running");
        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
        System.out.println("end the thread");
    }
}