package org.atyeti.concurrency;

public class CriticalSection{
    private static int count = 0; // shared resource
//static synchronized void increment()
//{
//    count++;
//}
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
                //increment(); // critical section
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
               count++;
                // increment(); // critical section
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected: 20000");
        System.out.println("Actual  : " + count);
    }
}