package org.atyeti.java.parallelFileEngine.reporter;



import org.atyeti.java.parallelFileEngine.collector.ResultCollector;

import java.util.Map;
import java.nio.file.Path;

public class ReportGenerator {
    public static void generateSummary(ResultCollector collector) {
        var results = collector.getResults();
        var errors = collector.getErrors();

        System.out.println("\n SEARCH SUMMARY ");
        if (results.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            results.entrySet().stream()
                    .sorted(Map.Entry.<Path, Integer>comparingByValue().reversed())
                    .forEach(e -> System.out.printf(" %s: %d matches%n",
                            e.getKey().getFileName(), e.getValue()));

            long total = results.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("\nTotal matches: " + total);
            System.out.println("Files with matches: " + results.size());
        }

        if (!errors.isEmpty()) {
            System.out.println("\n Errors:");
            errors.forEach(e -> System.out.printf(" %s: %s%n",
                    e.getFile().getFileName(), e.getReason()));
            System.out.println("Total errors: " + errors.size());
        }
    }
}