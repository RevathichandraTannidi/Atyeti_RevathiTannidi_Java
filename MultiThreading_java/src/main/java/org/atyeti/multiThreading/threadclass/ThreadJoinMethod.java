package org.atyeti.multiThreading.threadclass;

public class ThreadJoinMethod extends Thread {
    public ThreadJoinMethod(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(getName()) ;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinMethod t1=new ThreadJoinMethod("thread 1");
        ThreadJoinMethod t2=new ThreadJoinMethod("thread 2");
        ThreadJoinMethod t3=new ThreadJoinMethod("thread 3");
        ThreadJoinMethod t4=new ThreadJoinMethod("thread 4");
        System.out.println(t1.getName());

        t1.start();

        t2.start();
        t2.join();
        t3.start();
        t4.start();
        System.out.println("Threads are completed");

//t3.join();
//t4.join();
    }
}
