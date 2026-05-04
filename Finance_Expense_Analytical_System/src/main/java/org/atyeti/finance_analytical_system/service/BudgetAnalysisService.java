package org.atyeti.finance_analytical_system.service;

import org.atyeti.finance_analytical_system.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class BudgetAnalysisService {

    public double getTotalSpending(List<Transaction> list) {
        return list.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public Map<String, Double> getSpendingByCategory(List<Transaction> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)
                ));
    }

    public Optional<Map.Entry<String, Double>> getTopCategory(Map<String, Double> map) {
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    public void printSummary(List<Transaction> list) {

        double total = getTotalSpending(list);
        Map<String, Double> category = getSpendingByCategory(list);

        System.out.println("\n===== WealthPilot Spending Summary =====");
        System.out.println("Total Spending: ₹" + total);

        category.forEach((k, v) ->
                System.out.println(k + " : ₹" + v)
        );

        getTopCategory(category).ifPresent(entry ->
                System.out.println("Top Category: " + entry.getKey() + " ₹" + entry.getValue())
        );
    }
}