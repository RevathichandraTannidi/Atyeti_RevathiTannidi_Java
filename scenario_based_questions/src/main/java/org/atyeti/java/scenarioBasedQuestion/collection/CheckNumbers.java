package org.atyeti.java.scenarioBasedQuestion.collection;

public class CheckNumbers {

        private int num=0;
        private final int maxNum=20;
        public synchronized void printOdd() throws InterruptedException {
            while(num<=maxNum)
            {
                if(num%2==0) {
                    wait();
                }
                else {
                    System.out.println("odd number :"+num);
                    notify();
                    num++;
                }
            }
        }


    public synchronized void printEven() throws InterruptedException {
        while(num<=maxNum)
        {
            if(num%2!=0) {
                wait();
            }
            else {
                System.out.println("even number :"+num);
                notify();
                num++;
            }
        }
    }
}

