package org.transaction_fraud_detection;
import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;



public class TransactionFraudDetector {

    public static void main(String[] args) throws IOException {
        List<Transactionpojo> transactions = new ArrayList<>();


        StringBuilder json = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\27-05-2025(core_java)\\streams\\src\\main\\java\\org\\transaction_fraud_detection\\transactions.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line.trim());
            }
        }


        String[] entries = json.toString()
                .replaceAll("^\\[|\\]$", "")
                .split("},\\s*\\{");

        for (String entry : entries) {
            String clean = entry.replaceAll("[\\[\\]{}\"]", "");
            Map<String, String> fields = Arrays.stream(clean.split(","))
                    .map(s -> s.split(":", 2))
                    .collect(Collectors.toMap(
                            a -> a[0].trim(),
                            a -> a[1].trim()
                    ));

            transactions.add(new Transactionpojo(
                    fields.get("transactionId"),
                    fields.get("userId"),
                    Double.parseDouble(fields.get("amount")),
                    LocalDateTime.parse(fields.get("timestamp")),
                    fields.get("location")
            ));
        }


        Map<String, List<Transactionpojo>> byUser = transactions.stream()
                .collect(Collectors.groupingBy(t -> t.userId));

        System.out.println("users with >3 transactions in 5 minutes:");
        byUser.entrySet().stream().filter(entry -> entry.getValue().stream()
          .sorted(Comparator.comparing(Transactionpojo::getTimestamp))
        .flatMap(t1 -> entry.getValue().stream()
            .filter(t2 -> !t1.transactionId.equals(t2.transactionId))
        .filter(t2 -> Duration.between(t1.getTimestamp(), t2.getTimestamp()).abs().toMinutes() <= 5)).count() > 3)
                .forEach(entry -> {
                    System.out.println("User: " + entry.getKey());
                    entry.getValue().forEach(System.out::println);
                });

        System.out.println("\n Top 5 users by total transaction amount:");
        byUser.entrySet().stream()
                .map(e -> Map.entry(e.getKey(), e.getValue().stream().mapToDouble(t -> t.amount).sum()))
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": $" + e.getValue()));

        System.out.println("\n Users with transactions in different cities within 10 minutes:");
        byUser.entrySet().stream()
                .flatMap(entry -> {
                    List<Transactionpojo> sorted = entry.getValue().stream()
                            .sorted(Comparator.comparing(Transactionpojo::getTimestamp))
                            .collect(Collectors.toList());

                    return IntStream.range(0, sorted.size())
                            .boxed()
                            .flatMap(i -> IntStream.range(i + 1, sorted.size())
                                    .mapToObj(j -> new AbstractMap.SimpleEntry<>(sorted.get(i), sorted.get(j)))
                                    .filter(pair -> !pair.getKey().location.equals(pair.getValue().location))
                                    .filter(pair -> Duration.between(pair.getKey().getTimestamp(), pair.getValue().getTimestamp()).abs().toMinutes() <= 10)
                                    .map(pair -> "User: " + entry.getKey() + "\n  " + pair.getKey() + "\n  " + pair.getValue()));
                })
                .distinct()
                .forEach(System.out::println);
    }
}

