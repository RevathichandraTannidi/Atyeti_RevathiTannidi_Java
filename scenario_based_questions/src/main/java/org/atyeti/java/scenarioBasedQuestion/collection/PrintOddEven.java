package org.atyeti.java.scenarioBasedQuestion.collection;

public class PrintOddEven {
    public static void main(String[] args) {

                CheckNumbers print = new CheckNumbers();

                Thread t1 = new Thread(() -> {
                    try { print.printOdd(); } catch (InterruptedException e) {
                        System.out.println("thread" );
                    }
                });

                Thread t2 = new Thread(() -> {
                    try { print.printEven(); } catch (InterruptedException e) {}
                });

                t1.start();
                t2.start();
            }
        }


