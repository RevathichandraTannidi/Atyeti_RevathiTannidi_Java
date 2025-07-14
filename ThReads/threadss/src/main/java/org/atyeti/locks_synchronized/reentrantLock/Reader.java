package org.atyeti.locks_synchronized.reentrantLock;


  public class Reader implements Runnable {
        private final ReadWriteLock lock;
        private final int id;

        public Reader(ReadWriteLock lock, int id) {
            this.lock = lock;
            this.id = id;
        }

        public void run() {
            try {
                lock.lockRead();
                System.out.println("Reader " + id + " is reading...");
                Thread.sleep(1000);
                System.out.println("Reader " + id + " finished reading.");
                lock.unlockRead();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

