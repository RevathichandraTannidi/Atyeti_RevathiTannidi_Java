package com.carRental.service;

import com.carRental.entity.Rental;
import com.carRental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CSVReportService {

    private final RentalRepository rentalRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public String generateRentalHistoryCsv(LocalDate start, LocalDate end) {
        List<Rental> rentals = rentalRepository.findByStartDateBetween(start, end);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("RentalID,UserID,Username,CarID,CarName,PickupBranch,DropoffBranch,StartDate,EndDate,Status,Amount");

        for (Rental r : rentals) {
            pw.printf("%d,%d,%s,%d,%s,%s,%s,%s,%s,%s,%.2f%n",
                    r.getId(),
                    r.getUser().getId(),
                    r.getUser().getUsername(),
                    r.getCar().getId(),
                    r.getCar().getBrand() + " " + r.getCar().getModel(),
                    r.getPickupBranch().getName(),
                    r.getDropoffBranch().getName(),
                    r.getStartDate().format(formatter),
                    r.getEndDate().format(formatter),
                    r.getStatus().name(),
                    r.getPayment() != null ? r.getPayment().getAmount() : 0
            );
        }
        return sw.toString();
    }


    public String generateRevenueByBranchCsv(LocalDate start, LocalDate end) {
        List<Rental> rentals = rentalRepository.findByStartDateBetween(start, end);
        Map<String, Double> revenue = rentals.stream()
                .collect(Collectors.groupingBy(
                        r -> r.getPickupBranch().getName(),
                        Collectors.summingDouble(r -> r.getPayment() != null ? r.getPayment().getAmount() : 0)
                ));

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("Branch,TotalRevenue");
        revenue.forEach((branch, total) -> pw.printf("%s,%.2f%n", branch, total));
        return sw.toString();
    }


    public String generateRevenueByCarCsv(LocalDate start, LocalDate end) {
        List<Rental> rentals = rentalRepository.findByStartDateBetween(start, end);
        Map<String, Double> revenue = rentals.stream()
                .collect(Collectors.groupingBy(
                        r -> r.getCar().getBrand() + " " + r.getCar().getModel(),
                        Collectors.summingDouble(r -> r.getPayment() != null ? r.getPayment().getAmount() : 0)
                ));

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("Car,TotalRevenue");
        revenue.forEach((car, total) -> pw.printf("%s,%.2f%n", car, total));
        return sw.toString();
    }


    public String generateCarUsageCsv(LocalDate start, LocalDate end) {
        List<Rental> rentals = rentalRepository.findByStartDateBetween(start, end);
        Map<String, Long> usage = rentals.stream()
                .collect(Collectors.groupingBy(
                        r -> r.getCar().getBrand() + " " + r.getCar().getModel(),
                        Collectors.counting()
                ));

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("Car,NumberOfRentals");
        usage.forEach((car, count) -> pw.printf("%s,%d%n", car, count));
        return sw.toString();
    }


    public String generateCustomerLoyaltyCsv() {
        List<Rental> rentals = rentalRepository.findAll();
        Map<Long, List<Rental>> rentalsByUser = rentals.stream()
                .collect(Collectors.groupingBy(r -> r.getUser().getId()));

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("UserID,Username,Email,LoyaltyPoints,TotalRentals,TotalSpent");

        rentalsByUser.forEach((userId, userRentals) -> {
            var u = userRentals.get(0).getUser();
            double totalSpent = userRentals.stream()
                    .mapToDouble(r -> r.getPayment() != null ? r.getPayment().getAmount() : 0)
                    .sum();
            pw.printf("%d,%s,%s,%d,%d,%.2f%n",
                    u.getId(), u.getUsername(), u.getEmail(), u.getLoyaltyPoints(),
                    userRentals.size(), totalSpent);
        });

        return sw.toString();
    }
}
