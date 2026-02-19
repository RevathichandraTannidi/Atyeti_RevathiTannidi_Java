package org.atyeti.multiThreading.locks;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantDemo {
    private final ReentrantLock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " entered Outer");
            inner(); // Calling another method that requires the same lock
        } finally {
            lock.unlock();
        }
    }

    public void inner() {
        lock.lock(); // Same thread can acquire this again
        try {
            System.out.println(Thread.currentThread().getName() + " entered Inner");
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockEx {
    public static void main(String[] args) {
        ReentrantDemo demo = new ReentrantDemo();
        Thread t = new Thread(() -> demo.outer(), "Worker");
        t.start();
    }
}