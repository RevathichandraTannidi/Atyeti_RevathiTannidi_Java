package org.atyeti.java.parallelFileEngine.reporter;

import org.atyeti.java.parallelFileEngine.collector.ResultCollector;
import org.atyeti.java.parallelFileEngine.model.SearchError;

import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReportGenerator {

    public static void generateSummary(ResultCollector collector) {
        ConcurrentHashMap<Path, ConcurrentHashMap<String, Integer>> results = collector.getResults();
        var errors = collector.getErrors();

        System.out.println("===== SEARCH SUMMARY =======\n");

        //  Print overall totals per keyword
        ConcurrentHashMap<String, Integer> totals = collector.aggregateTotals();
        if (totals.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("Overall keyword totals:");
            totals.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(e -> System.out.printf("  '%s' → %d matches%n", e.getKey(), e.getValue()));

            System.out.println();
        }

        // Print per-file breakdown
        if (!results.isEmpty()) {
            for (Map.Entry<Path, ConcurrentHashMap<String, Integer>> fileEntry : results.entrySet()) {
                Path file = fileEntry.getKey();
                ConcurrentHashMap<String, Integer> perKey = fileEntry.getValue();
                System.out.println("File: " + file.toString());
                // print keywords in the same order as totals keys (optional)
                perKey.forEach((k, v) -> System.out.printf("   '%s' → %d matches%n", k, v));
                System.out.println();
            }

            long totalMatches = totals.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total matches: " + totalMatches);
            System.out.println("Files with matches: " + results.size());
        }

        // Print errors (if any)
        if (!errors.isEmpty()) {
            System.out.println("\nErrors:");
            errors.forEach((SearchError e) -> System.out.printf("  %s : %s%n", e.getFile().getFileName(), e.getReason()));
            System.out.println("Total errors: " + errors.size());
        }
    }
}
