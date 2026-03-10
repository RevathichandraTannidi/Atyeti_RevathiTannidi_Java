package org.atyeti.java.scenarioBasedQuestion.collection;

public class PrintNumAndAlphabet {
    public static void main(String[] args) {
        AlphabetNum print = new AlphabetNum();

        Thread t1 = new Thread(() -> {
            try { print.printAlphabet(); } catch (InterruptedException e) {
                System.out.println("thread" );
            }
        });

        Thread t2 = new Thread(() -> {
            try { print.printNumbers(); } catch (InterruptedException e) {}
        });

        t1.start();
        t2.start();
    }
}
