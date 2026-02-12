package org.atyeti.multiThreading.threadclass;

public class RunnableInterface {
    public static void main(String[] args) {
        Thread t=new Thread(()->
        {
            System.out.println("\nExample with multiple statements");
            System.out.println("revathi chandra");
            System.out.println("atchyuth thota");
        });
        t.start();

        Runnable task=()-> System.out.println(" \nusing  a Variable \nrevathi chandra tannidi");
        Thread t1=new Thread(task);
        t1.start();

        new Thread(()-> System.out.println("\nBy using lambda directly inside thread class \n Tannidi revathi chandra")).start();
    }
}
