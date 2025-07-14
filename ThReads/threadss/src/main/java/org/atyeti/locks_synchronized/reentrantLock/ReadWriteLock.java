package org.atyeti.locks_synchronized.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ReadWriteLock {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cRead = lock.newCondition();
    private final Condition cWrite = lock.newCondition();
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    public void lockRead() throws InterruptedException {
        lock.lock();
        try {
            while (writers > 0 || writeRequests > 0) {
                cRead.await();
            }
            readers++;
        } finally {
            lock.unlock();
        }
    }

    public void unlockRead() {
        lock.lock();
        try {
            readers--;
            if (readers == 0) {
                cWrite.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void lockWrite() throws InterruptedException {
        lock.lock();
        try {
            writeRequests++;
            while (readers > 0 || writers > 0) {
                cWrite.await();
            }
            writeRequests--;
            writers++;
        } finally {
            lock.unlock();
        }
    }

    public void unlockWrite() {
        lock.lock();
        try {
            writers--;
            if (writeRequests > 0) {
                cWrite.signal();
            } else {
                cRead.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}

