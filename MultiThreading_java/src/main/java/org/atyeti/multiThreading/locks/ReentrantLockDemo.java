package org.atyeti.multiThreading.locks;

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private final Lock lock = new ReentrantLock();

    public void methodA() {

        lock.lock();

        try {

            System.out.println(Thread.currentThread().getName() + " acquired lock in methodA");

            methodB(); // same thread re-enters the lock

        } finally {

            lock.unlock();

            System.out.println(Thread.currentThread().getName() + " released lock in methodA");

        }

    }

    public void methodB() {

        lock.lock();

        try {

            System.out.println(Thread.currentThread().getName() + " re-entered lock in methodB");

        } finally {

            lock.unlock();

            System.out.println(Thread.currentThread().getName() + " released lock in methodB");

        }

    }

    public static void main(String[] args) {

        ReentrantLockDemo demo = new ReentrantLockDemo();

        Runnable task = () -> {

            demo.methodA();

        };

        Thread t1 = new Thread(task, "Thread-1");

        Thread t2 = new Thread(task, "Thread-2");

        t1.start();

        t2.start();

    }

}

