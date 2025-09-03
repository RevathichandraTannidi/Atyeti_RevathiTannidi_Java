package org.atyeti.car_rental_system.car.dtos;



import lombok.*;
import java.util.Map;

public class ReportDtos {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RevenueReport {
        private Map<String, Double> revenueByBranch;
        private Map<String, Double> revenueByCarModel;
        private Double totalRevenue;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UsageReport {
        private Map<String, Long> carUsageCount;
        private String mostRentedCar;
        private String leastRentedCar;
    }
}
