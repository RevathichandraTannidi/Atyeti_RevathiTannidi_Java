package org.atyeti.ordermatching.filehandling;


import org.atyeti.ordermatching.model.OrderType;
import org.atyeti.ordermatching.model.Orders;
import org.atyeti.ordermatching.model.TradeType;
import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static List<Orders> readAllOrders(String filePath) throws IOException {
        List<Orders> orders = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line=br.readLine() ;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length < 8) continue;

                Orders order = Orders.builder()
                        .orderId(parts[0].trim())
                        .traderId(parts[1].trim())
                        .tradeType(TradeType.valueOf(parts[2].trim()))
                        .orderType(OrderType.valueOf(parts[3].trim()))
                        .price(Double.parseDouble(parts[4].trim()))
                        .quantity(Long.parseLong(parts[5].trim()))
                        .countryCode(parts[6].trim())
                        .timestamp(parseTimestamp(parts[7].trim()))
                        .build();

                orders.add(order);
            }
        }
        return orders;
    }

    public static Timestamp parseTimestamp(String timestamp) {
        LocalDateTime dateTime = LocalDateTime.parse(timestamp.trim(), formatter);
        return Timestamp.valueOf(dateTime);
    }
}
