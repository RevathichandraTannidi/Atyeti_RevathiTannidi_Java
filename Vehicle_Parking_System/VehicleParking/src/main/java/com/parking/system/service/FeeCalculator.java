package com.parking.system.service;



import java.time.Duration;

public interface FeeCalculator {

    double calculateFare(Duration duration);
}
