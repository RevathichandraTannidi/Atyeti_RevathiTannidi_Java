package com.atyeti.java.salesAnalzer.util;

import com.atyeti.java.salesAnalzer.exception.DataAnalysisException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class CSVWriterUtil {

    public static void revenueToCSV(double totalRevenue, String filePath) throws DataAnalysisException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("TotalRevenue\n ");
              bw.write(String.format("%.2f", totalRevenue));
               System.out.println("revenue : " + filePath);
        } catch (Exception e) {
             throw new DataAnalysisException("error in revenue CSV: " + filePath, e);
        }
    }

    public static void topProductsToCSV(List<Map.Entry<String, Integer>> topProducts, String filePath) throws DataAnalysisException {
        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(filePath))) {
            bw1.write("ProductId,UnitsSold\n");
              for (Map.Entry<String, Integer> entry : topProducts) {
                  bw1.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
               System.out.println("Top products  " + filePath);
        } catch (Exception e) {
             throw new DataAnalysisException("error in products CSV: " + filePath, e);
        }
    }

    public static void revenueByRegionToCSV(Map<String, Double> regionRevenueMap, String filePath) throws DataAnalysisException {
        try (BufferedWriter bww = new BufferedWriter(new FileWriter(filePath))) {
             bww.write("Region,Revenue\n");
            for (Map.Entry<String, Double> entry : regionRevenueMap.entrySet()) {
                 bww.write(entry.getKey() + "," + String.format("%.2f", entry.getValue()) + "\n");
             }
               System.out.println("Region revenue : " + filePath);
        }
        catch (Exception e) {
             throw new DataAnalysisException("error in region CSV: " + filePath, e);
        }
    }
}
