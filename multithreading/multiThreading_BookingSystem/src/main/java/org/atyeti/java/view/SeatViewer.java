package org.atyeti.java.view;


import org.atyeti.java.util.SeatStore;

public class SeatViewer {

    public static void showAvailableSeats() {
        System.out.println("\n AVAILABLE SEATS  ");
        for (int i = 1; i <= SeatStore.TOTAL_SEATS; i++) {
            if (!SeatStore.bookedSeats.containsKey(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void showBookedSeats() {
        System.out.println("\n  BOOKED SEATS ");
        SeatStore.bookedSeats.forEach((seat, name) ->
                System.out.println("Seat " + seat + " -> " + name)
        );
    }
}
