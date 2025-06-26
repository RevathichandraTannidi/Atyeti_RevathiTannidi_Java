package com.atyeti.java.salesAnalzer.model;

import java.time.LocalDate;

public class SaleRecord {

        private String productId;
        private String region;
        private int unitsSold;
        private double unitPrice;
        private LocalDate saleDate;

        public SaleRecord(String productId, String region, int unitsSold, double unitPrice, LocalDate saleDate) {
            this.productId = productId;
            this.region = region;
            this.unitsSold = unitsSold;
            this.unitPrice = unitPrice;
            this.saleDate = saleDate;
        }


    public String getProductId() {
        return productId;
    }

    public String getRegion() {
        return region;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getTotalRevenue() {
            return unitsSold * unitPrice;
        }

}
