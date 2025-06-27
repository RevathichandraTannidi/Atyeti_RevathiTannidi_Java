package com.atyeti.java.salesAnalzer.service;

import com.atyeti.java.salesAnalzer.exception.DataAnalysisException;
import com.atyeti.java.salesAnalzer.model.SaleRecord;
import com.atyeti.java.salesAnalzer.util.CSVWriterUtil;

import java.util.List;

public class RevenueCalculator extends  Thread {

    private final List<SaleRecord> records;

    public RevenueCalculator(List<SaleRecord> records) {
        this.records = records;
    }

    @Override
    public void run() {
        try {
            double totalRevenue = records.stream()
                    .mapToDouble(SaleRecord::getTotalRevenue).sum();

            System.out.printf("Total Revenue: $%.2f%n", totalRevenue);

    CSVWriterUtil.revenueToCSV(totalRevenue, "C:\\Users\\RevathiTannidi\\IdeaProjects\\POC-projects\\sales_Report_generator\\src\\main\\reports\\revenue.csv");

        } catch (DataAnalysisException e) {
          System.err.println("Revenue calculation failed: " + e.getMessage());

        }
    }
}
