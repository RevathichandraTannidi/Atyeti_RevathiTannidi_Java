package org.atyeti.multiThreading.threadclass;

public class Mythread1 extends Thread{
    public void run()
    {
        System.out.println("no args ");
    }
    public void start()
    {
        super.start();
        System.out.println("args run");
    }


    public static void main(String[] args) {
        Mythread1 my=new Mythread1();
        my.start();

    }
}
