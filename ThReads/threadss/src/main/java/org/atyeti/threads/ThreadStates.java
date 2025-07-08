package org.atyeti.threads;

public class ThreadStates {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
        System.out.println("current thread state " + Thread.currentThread().getState());
            for (int i = 0; i < 3; i++) {

                System.out.println("working " + i);
            }

            try {
                System.out.println("sleeping thread");
                    Thread.sleep(100);
                    System.out.println("after sleep");
                } catch (InterruptedException e) {
                    System.out.println("interputed");
                }

                System.out.println("close thread");
            });

            System.out.println("new thread: " + t.getState());

            t.start();
            Thread.sleep(10);

            System.out.println("after start and sleep the state pff thread: " + t.getState());


        Thread joiner = new Thread(() -> {
            try {
                System.out.println("joiner thread");
                 t.join();
                System.out.println("t is finished");
            } catch (InterruptedException e) {
                System.out.println(" interputed thread");
            }
        });

            joiner.start();
             t.join();
            System.out.println("main thread completed: " + t.getState());
        }
    }

