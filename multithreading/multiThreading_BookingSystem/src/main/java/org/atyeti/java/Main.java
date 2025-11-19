package org.atyeti.java;

import org.atyeti.java.model.Passenger;
import org.atyeti.java.service.BookingTask;
import org.atyeti.java.service.AuditService;
import org.atyeti.java.util.LoggerUtil;
import org.atyeti.java.util.SeatStore;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println("Log file: " + LoggerUtil.getLogPath());

        System.out.println(" MULTI-THREADED TICKET BOOKING SYSTEM ");

        while (true) {

            System.out.print("\nEnter how many tickets you need: ");
            int seatCount = sc.nextInt();
            sc.nextLine();

            List<Passenger> list = new ArrayList<>();

            for (int i = 1; i <= seatCount; i++) {
                System.out.print("Enter Passenger " + i + " Name: ");
                list.add(new Passenger(sc.nextLine()));
            }


            Future<String> future = service.submit(new BookingTask(list));

            System.out.println("\n" + future.get());

            System.out.print("\nDo you want to book more tickets? (yes/no): ");
            if (!sc.nextLine().equalsIgnoreCase("yes")) break;
        }

        System.out.println("\n FINAL BOOKED SEATS ");
        SeatStore.bookedSeats.forEach(
                (seat, name) -> System.out.println("Seat " + seat + " -> " + name)
        );

        System.out.println("\nAUDIT LOG");
        AuditService.showAuditHistory();

        service.shutdown();
    }
}
