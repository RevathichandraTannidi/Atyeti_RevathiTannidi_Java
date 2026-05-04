package org.atyeti.finance_analytical_system.service;

import org.atyeti.finance_analytical_system.model.Transaction;

import java.util.List;

public class BudgetAlertService {

    public void checkAndNotify(List<Transaction> list, double monthlyBudget) {

        double total = list.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        if (total >= monthlyBudget * 0.8) {
            System.out.println(" Alert: You have used 80% of your budget!");
        }

        if (total > monthlyBudget) {
            System.out.println(" Budget exceeded!");
        }
    }
}