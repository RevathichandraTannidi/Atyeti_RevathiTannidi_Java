package org.atyeti.multiThreading.threadclass;
class Problem2 {
    static int x = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> x++);
        Thread t2 = new Thread(() -> x++);

        t1.start();
        t2.start();

        System.out.println(x);
    }
}