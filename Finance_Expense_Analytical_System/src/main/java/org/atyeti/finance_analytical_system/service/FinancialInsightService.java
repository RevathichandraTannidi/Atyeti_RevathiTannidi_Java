package org.atyeti.finance_analytical_system.service;


import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.model.User;

import java.util.List;

public class FinancialInsightService {

    public int calculateFinancialScore(User user, List<Transaction> transactions) {

        double totalSpend = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        double income = user.getIncome();

        if (income == 0) return 0;

        double savingsRatio = (income - totalSpend) / income;

        int score = (int) (savingsRatio * 100);

        if (score < 0) score = 0;
        if (score > 100) score = 100;

        return score;
    }

    public String getScoreRemark(int score) {
        if (score >= 75) return "Excellent Financial Health";
        else if (score >= 50) return "Good Financial Health";
        else return "Poor Financial Health - Improve Savings";
    }
}
