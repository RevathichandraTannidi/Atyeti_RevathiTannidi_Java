package com.atyeti.java.salesAnalzer.util;

import com.atyeti.java.salesAnalzer.exception.DataAnalysisException;
import com.atyeti.java.salesAnalzer.model.SaleRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {
    public static List<SaleRecord> readSalesFromCSV(String filePath) throws DataAnalysisException {
        List<SaleRecord> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
             br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                     String productId = data[0];
                     String region = data[1];
                    int unitsSold = Integer.parseInt(data[2]);
                    double unitPrice = Double.parseDouble(data[3]);
                    LocalDate saleDate = LocalDate.parse(data[4]);

                    records.add(new SaleRecord(productId, region, unitsSold, unitPrice, saleDate));
                }
            }
        } catch (Exception e) {
            throw new DataAnalysisException("error while reading: " + filePath, e);
        }
        return records;
    }
}
