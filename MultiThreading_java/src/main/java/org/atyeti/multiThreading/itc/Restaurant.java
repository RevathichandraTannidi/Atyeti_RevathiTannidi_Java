package org.atyeti.multiThreading.itc;
public class Restaurant {
    private String order;
    private boolean ready = false;

    public synchronized void cook(String item) throws InterruptedException {

        while (ready) wait();

        System.out.println("Chef preparing " + item);
        Thread.sleep(1000);

        order = item;
        ready = true;

        notifyAll();
    }

    public synchronized void serve() throws InterruptedException {

        while (!ready) wait();

        System.out.println("Waiter serving " + order);
        ready = false;

        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        Restaurant r=new Restaurant();
        r.cook("biryani");
        r.serve();
    }
}
