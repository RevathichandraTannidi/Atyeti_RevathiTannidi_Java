package org.atyeti.multiThreading.locks;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource {
    private int value = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readValue() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reads: " + value);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeValue(int newValue) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writes: " + newValue);
            value = newValue;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
public class RWLockDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable reader = resource::readValue;
        Runnable writer = () -> resource.writeValue(10);

        for (int i = 0; i < 3; i++) new Thread(reader).start();
        new Thread(writer).start();
        new Thread(reader).start();
    }
}