package org.atyeti.locks_synchronized.bankUsingReentrant;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class BankAccount {
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());

    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public void deposit(double amount) {
        balance += amount;
          logger.info("Account " + id + " deposited: " + amount + ", balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
              logger.info("Account " + id + " withdrew: " + amount + ",balance: " + balance);
            return true;
        } else {
            logger.warning("Account " + id + " insufficient funds for withdrawal: " + amount);
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public static void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount first = from.getId() < to.getId() ? from : to;
          BankAccount second = from.getId() < to.getId() ? to : from;

        first.getLock().lock();
        second.getLock().lock();

        try {
            if (from.withdraw(amount)) {
                  to.deposit(amount);
                logger.info(String.format("transferred %.2f from Account %d to Account %d", amount, from.getId(), to.getId()));
            } else {
                  logger.warning(String.format("failed to transfer %.2f from Account %d to Account %d due to insufficient funds", amount, from.getId(), to.getId()));
            }
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }
}

//Requirements:
//Create a BankAccount class with deposit(), withdraw(), and transferTo() methods.
//Use ReentrantLock to protect each account’s balance.
//Implement a transferTo() method that:
//Locks both accounts involved in the transfer.
//Avoids deadlocks by always locking accounts in a consistent order (e.g., by account ID).
//Simulate multiple threads transferring money between accounts.
// Challenge:
//Prevent deadlocks when two threads try to transfer money between the same pair of accounts in opposite directions.
//Ensure thread-safe balance updates.