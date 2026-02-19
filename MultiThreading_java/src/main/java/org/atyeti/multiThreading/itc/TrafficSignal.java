package org.atyeti.multiThreading.itc;

public class TrafficSignal {

    private boolean northSouthGreen = true; // start with NS

    public synchronized void northSouthPass(String car)
            throws InterruptedException {

        while (!northSouthGreen) {
            wait();
        }

        System.out.println(car + " passing NORTH-SOUTH");

        // switch signal
        northSouthGreen = false;

        notifyAll();
    }

    public synchronized void eastWestPass(String car)
            throws InterruptedException {

        while (northSouthGreen) {
            wait();
        }

        System.out.println(car + " passing EAST-WEST");

        // switch signal
        northSouthGreen = true;

        notifyAll();
    }

    public static void main(String[] args) {
        TrafficSignal signal = new TrafficSignal();

        Runnable northSouth = () -> {
            String[] cars = {"Car A", "Car B", "Car C"};
            for (String car : cars) {
                try { signal.northSouthPass(car); }
                catch (Exception e) {}
            }
        };

        Runnable eastWest = () -> {
            String[] cars = {"Car X", "Car Y", "Car Z"};
            for (String car : cars) {
                try { signal.eastWestPass(car); }
                catch (Exception e) {}
            }
        };

        new Thread(northSouth).start();
        new Thread(eastWest).start();
    }
}

