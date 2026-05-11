package org.atyeti.finance_analytical_system.service;

import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.model.User;

import java.util.List;

public class RiskAnalysisService {

    public void detectRisk(User user, List<Transaction> list) {

        double total = list.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        double income = user.getIncome();

        double ratio = total / income;

        if (ratio > 0.9) {
            System.out.println(" HIGH RISK: You are spending more than 90% of income!");
        } else if (ratio > 0.7) {
            System.out.println(" WARNING: High spending detected!");
        } else {
            System.out.println(" Spending is under control");
        }
    }
}