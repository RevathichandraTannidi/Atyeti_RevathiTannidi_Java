package service;



import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderReader {
    public List<Order> readOrdersFromCSV(String filename) {
        List<Order> orders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 5) continue;
                orders.add(new Order(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]),parts[4]));
            }
        } catch (IOException e) {
            System.err.println("Error reading input CSV: " + e.getMessage());
        }

        return orders;
    }
}
