package service;
import model.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderCsv {

    private final String fulfilledFile = "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\ThReads\\threadss\\src\\main\\poc\\orderfulfillmentSystem\\csvfiles\\fulfilled_orders.csv";
    private final String rejectedFile = "C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\ThReads\\threadss\\src\\main\\poc\\orderfulfillmentSystem\\csvfiles\\Rejected_orders.csv";

    public synchronized void logFulfilledOrder(Order order) {
        writeToFile(fulfilledFile, order);
    }

    public synchronized void logRejectedOrder(Order order) {
        writeToFile(rejectedFile, order);
    }

    private void writeToFile(String filename, Order order) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(order.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    }

