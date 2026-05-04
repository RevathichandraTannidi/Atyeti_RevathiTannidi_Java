package org.atyeti.finance_analytical_system.util;

import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.service.BudgetAnalysisService;

import java.util.List;
import java.util.Map;

public class ReportGenerator {

    public void generateMonthlyReport(List<Transaction> list, double income) {

        BudgetAnalysisService bs = new BudgetAnalysisService();

        double total = bs.getTotalSpending(list);
        double saved = income - total;

        Map<String, Double> category = bs.getSpendingByCategory(list);

        System.out.println("\n===== WealthPilot Monthly Report =====");
        System.out.println("Total Income  : ₹" + income);
        System.out.println("Total Spent   : ₹" + total);
        System.out.println("Total Saved   : ₹" + saved);

        System.out.println("\nCategory Breakdown:");
        category.forEach((k, v) ->
                System.out.println(k + " : ₹" + v)
        );

    }
}