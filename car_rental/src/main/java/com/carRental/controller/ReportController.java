package com.carRental.controller;

import com.carRental.dtos.RevenueByBranchDTO;
import com.carRental.dtos.RevenueByCarDTO;
import com.carRental.service.CSVReportService;
import com.carRental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final CSVReportService csvReportService;
    private final RentalService rentalService;



    @GetMapping("/rentals/csv")
    public ResponseEntity<String> rentalHistoryReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        String csv = csvReportService.generateRentalHistoryCsv(start, end);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"rental_history.csv\"")
                .body(csv);
    }

    @GetMapping("/revenue/branch/csv")
    public ResponseEntity<String> revenueByBranchReportCsv(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        String csv = csvReportService.generateRevenueByBranchCsv(start, end);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"revenue_by_branch.csv\"")
                .body(csv);
    }

    @GetMapping("/revenue/car/csv")
    public ResponseEntity<String> revenueByCarReportCsv(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        String csv = csvReportService.generateRevenueByCarCsv(start, end);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"revenue_by_car.csv\"")
                .body(csv);
    }

    @GetMapping("/car-usage/csv")
    public ResponseEntity<String> carUsageReportCsv(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        String csv = csvReportService.generateCarUsageCsv(start, end);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"car_usage.csv\"")
                .body(csv);
    }

    @GetMapping("/customer-loyalty/csv")
    public ResponseEntity<String> customerLoyaltyReportCsv() {
        String csv = csvReportService.generateCustomerLoyaltyCsv();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"customer_loyalty.csv\"")
                .body(csv);
    }



    @GetMapping("/revenue/branch")
    public List<RevenueByBranchDTO> revenueByBranchReportJson(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return rentalService.getRevenueByBranch(start, end);
    }

    @GetMapping("/revenue/car")
    public List<RevenueByCarDTO> revenueByCarReportJson(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return rentalService.getRevenueByCar(start, end);
    }
}
