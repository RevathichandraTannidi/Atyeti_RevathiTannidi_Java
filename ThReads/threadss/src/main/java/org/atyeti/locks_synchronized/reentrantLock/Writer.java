package org.atyeti.locks_synchronized.reentrantLock;

public class Writer implements Runnable {
    private final ReadWriteLock lock;
    private final int id;

    public Writer(ReadWriteLock lock, int id) {
        this.lock = lock;
        this.id = id;
    }

    public void run() {
        try {
            lock.lockWrite();
            System.out.println("Writer " + id + " is writing...");
            Thread.sleep(1500);
            System.out.println("Writer " + id + " finished writing.");
            lock.unlockWrite();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
