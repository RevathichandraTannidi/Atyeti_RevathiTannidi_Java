package com.parking.system.service;


import org.springframework.stereotype.Service;

import java.time.Duration;
@Service
public class Feeservice implements FeeCalculator{
    private static final double HOURLY_RATE = 20.0;


    @Override
    public double calculateFare(Duration duration) {
        long hours = duration.toHours();
        return Math.max(1, hours) * HOURLY_RATE;
    }
}
