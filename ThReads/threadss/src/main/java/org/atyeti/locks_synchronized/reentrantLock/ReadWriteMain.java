package org.atyeti.locks_synchronized.reentrantLock;

public class ReadWriteMain {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReadWriteLock();

        for (int i = 1; i <= 3; i++) {
            new Thread(new Reader(lock, i)).start();
        }

        for (int i = 1; i <= 2; i++) {
            new Thread(new Writer(lock, i)).start();
        }

        for (int i = 4; i <= 6; i++) {
            new Thread(new Reader(lock, i)).start();
        }
    }
}
