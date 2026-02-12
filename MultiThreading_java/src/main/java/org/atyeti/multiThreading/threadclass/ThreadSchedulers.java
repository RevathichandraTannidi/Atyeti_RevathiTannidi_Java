package org.atyeti.multiThreading.threadclass;

public class ThreadSchedulers  extends Thread {
    public ThreadSchedulers(String name,int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        System.out.println(getName() + "  with priority "+ getPriority() +" is running .");
    }
//

    public static void main(String[] args) throws InterruptedException {
        ThreadSchedulers t1=new ThreadSchedulers("Thread 1",2);
        ThreadSchedulers t2=new ThreadSchedulers("Thread 2",7);
        ThreadSchedulers t3=new ThreadSchedulers("Thread 3",9);
        ThreadSchedulers t4=new ThreadSchedulers("Thread 4",4);
        ThreadSchedulers t5=new ThreadSchedulers("Thread 5",5);
        ThreadSchedulers t6=new ThreadSchedulers("Thread 6",1);

        t1.start();
        t2.start();
        sleep(200);
        t3.start();

        t4.start();
        t5.start();
        t6.start();
    }
}
