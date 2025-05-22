package com.atyeti.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class File1 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Map<String, Integer> productNameCount = new HashMap<>();
 final String filePath="C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\22-5-2025(core_java)\\java\\src\\com\\atyeti\\files\\revathi.csv";


 try(
     BufferedReader br=new BufferedReader(new FileReader(filePath))){

     String line;

     while ((line=br.readLine())!=null)
     {

         String[] values=line.split(",");
         if (values.length != 5) {
             System.out.println("Skipping malformed line: " + line);
             continue;
         }
     try
         {
             int productID = Integer.parseInt(values[0].trim());
             String productName = values[1].trim();
             String category = values[2].trim();
             double price = Double.parseDouble(values[3].trim());
             int stock = Integer.parseInt(values[4].trim());
             Product product=new Product(
                     productID,productName,category,price,stock);
             products.add(product);
             productNameCount.put(productName, productNameCount.getOrDefault(productName, 0) + 1);

         } catch (NumberFormatException e) {
         System.out.println("skipping the header");
     }
     }
     System.out.println("\nDuplicate Product Names:");
     for (Map.Entry<String, Integer> entry : productNameCount.entrySet()) {
         if (entry.getValue() > 1) {
             System.out.println(entry.getKey() + ": " + entry.getValue() + " occurrences");
         }
     }

    } catch (Exception e) {
     System.out.println("eroor");
 }
}}
