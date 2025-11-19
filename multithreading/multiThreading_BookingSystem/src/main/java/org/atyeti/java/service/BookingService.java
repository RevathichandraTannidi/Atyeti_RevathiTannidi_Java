package org.atyeti.java.service;

import org.atyeti.java.model.Passenger;
import org.atyeti.java.model.PaymentResult;
import org.atyeti.java.util.SeatStore;
import org.atyeti.java.service.PaymentService;
import org.atyeti.java.service.AuditService;
import org.atyeti.java.util.LoggerUtil;

import java.util.*;

public class BookingService {

    public String bookRandomSeats(List<Passenger> passengers) {

        PaymentService paymentService = new PaymentService();
        double totalAmount = passengers.size() * 200;

        PaymentResult result = paymentService.processPayment(totalAmount);

        if (!result.isSuccess()) {
            AuditService.log("Payment Failed for " + passengers.size() + " seats.");
            LoggerUtil.log("PAYMENT FAILED: " + result.getMessage());
            return " Booking Failed: " + result.getMessage();
        }

        AuditService.log("Payment Success for " + passengers.size() + " seats.");
        LoggerUtil.log("PAYMENT SUCCESS: " + result.getMessage());

        SeatStore.LOCK.lock();
        try {
            int count = passengers.size();

            List<Integer> freeSeats = new ArrayList<>();
            for (int i = 1; i <= SeatStore.TOTAL_SEATS; i++) {
                if (!SeatStore.bookedSeats.containsKey(i)) {
                    freeSeats.add(i);
                }
            }

            if (freeSeats.size() < count) {
                String msg = "FAILED: Only " + freeSeats.size() + " seats left.";
                AuditService.log(msg);
                LoggerUtil.log(msg);
                return msg;
            }

            Collections.shuffle(freeSeats);

            List<Integer> allocated = freeSeats.subList(0, count);

            int index = 0;
            for (Integer seat : allocated) {
                SeatStore.bookedSeats.put(seat, passengers.get(index++).getName());
            }

            String successMessage = "BOOKED RANDOM SEATS: " + allocated;

            AuditService.log(successMessage);
            LoggerUtil.log(successMessage);

            return successMessage;

        } finally {
            SeatStore.LOCK.unlock();
        }
    }
}
