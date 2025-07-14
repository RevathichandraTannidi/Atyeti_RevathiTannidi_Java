package org.atyeti.locks_synchronized.bankUsingReentrant;

import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MainBank {
    private static final Logger logger = Logger.getLogger(MainBank.class.getName());

    public static void main(String[] args) {
        setupLogging();

    BankAccount acc1 = new BankAccount(1, 1000);
        BankAccount acc2 = new BankAccount(2, 1000);

        Runnable transfer1 = () -> {
             Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                double amount = rand.nextInt(200);
                BankAccount.transfer(acc1, acc2, amount);
                sleep();
            }
        };

        Runnable transfer2 = () -> {
            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                double amount = rand.nextInt(200);
                BankAccount.transfer(acc2, acc1, amount);
                sleep();
            }
        };

        new Thread(transfer1).start();
        new Thread(transfer2).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
              logger.warning("interrupted thread.");
        }
    }

    private static void setupLogging() {
        Logger rootLogger = Logger.getLogger("");
          ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
          handler.setLevel(Level.INFO);
         rootLogger.addHandler(handler);
        rootLogger.setLevel(Level.INFO);
    }
}
