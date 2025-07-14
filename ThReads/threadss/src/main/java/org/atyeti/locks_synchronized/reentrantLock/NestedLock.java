package org.atyeti.locks_synchronized.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class NestedLock {
    private final ReentrantLock lock = new ReentrantLock();
    private int orderCount = 0;

    public void outer() {
        lock.lock();
        try {
            System.out.println("outer(): lock count = " + lock.getHoldCount());

            orderCount++;
            System.out.println("outer(): " + orderCount);

            inner();
        } finally {
            lock.unlock();
            System.out.println("outer(): after unlock, count = " + lock.getHoldCount());
        }
    }

    public void inner() {
        lock.lock();
        try {
            System.out.println("inner(): lock count = " + lock.getHoldCount());

            if (orderCount % 2 == 0) {
                System.out.println("inner(): Order" + orderCount + " passed validation.");
            } else {
                System.out.println("inner(): Order " + orderCount + " flagged for review.");
            }
        } finally {
            lock.unlock();
            System.out.println("inner(): after unlock, count = " + lock.getHoldCount());
        }
    }
}