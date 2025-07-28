package com.parking.system.util;


public class ParkingFeeCalculator {

    private static final double HOURLY_RATE = 50.0;

    public static double calculateFee(long hoursParked) {
        return hoursParked * HOURLY_RATE;
    }
}
