package org.atyeti.multiThreading.itc;

public class Turns {
    private boolean firstTurn=false;
    public synchronized void  setFirstTurn() throws InterruptedException {
        while (!firstTurn)
            wait();
     firstTurn=false;
        notify();
    }



    public  synchronized  void setSecondTurn() throws InterruptedException
    {
        while(firstTurn)
        {
            wait();

        }
        firstTurn=true;
        notify();
    }
}
