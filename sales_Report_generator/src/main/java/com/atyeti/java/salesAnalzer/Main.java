package com.atyeti.java.salesAnalzer;

import com.atyeti.java.salesAnalzer.exception.DataAnalysisException;
import com.atyeti.java.salesAnalzer.model.SaleRecord;
import com.atyeti.java.salesAnalzer.service.ProductAnalyzer;
import com.atyeti.java.salesAnalzer.service.RegionAnalyzer;
import com.atyeti.java.salesAnalzer.service.RevenueCalculator;
import com.atyeti.java.salesAnalzer.util.CSVReaderUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\RevathiTannidi\\IdeaProjects\\POC-projects\\sales_Report_generator\\src\\main\\resources\\sales.csv";

        try {
            List<SaleRecord> salesRecords = CSVReaderUtil.readSalesFromCSV(filePath);

            if (salesRecords.isEmpty()) {
                 System.out.println("empty folder ");

            }

             new RevenueCalculator(salesRecords).start();
               new ProductAnalyzer(salesRecords).start();
              new RegionAnalyzer(salesRecords).start();

        } catch (DataAnalysisException e) {
            System.err.println(" error: " + e.getMessage());

        }
    }


}
