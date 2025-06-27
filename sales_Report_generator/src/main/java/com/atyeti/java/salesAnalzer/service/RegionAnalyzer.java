package com.atyeti.java.salesAnalzer.service;
import com.atyeti.java.salesAnalzer.exception.DataAnalysisException;
import com.atyeti.java.salesAnalzer.model.SaleRecord;
import com.atyeti.java.salesAnalzer.util.CSVWriterUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegionAnalyzer extends Thread{

    private final List<SaleRecord> records;

    public RegionAnalyzer(List<SaleRecord> records) {
        this.records = records;
    }

    @Override
    public void run() {
        try {
            Map<String, Double> revenueByRegion = records.stream()
                    .collect(Collectors.groupingBy(SaleRecord::getRegion,
            Collectors.summingDouble(SaleRecord::getTotalRevenue)));

            System.out.println("Revenue by Region:");
                revenueByRegion.forEach((region, revenue) ->
        System.out.printf("%s: $%.2f%n", region, revenue));

  CSVWriterUtil.revenueByRegionToCSV(revenueByRegion, "C:\\Users\\RevathiTannidi\\IdeaProjects\\POC-projects\\sales_Report_generator\\src\\main\\reports\\revenue_by_region.csv");

        } catch (DataAnalysisException e) {
               System.err.println("Region analysis failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
