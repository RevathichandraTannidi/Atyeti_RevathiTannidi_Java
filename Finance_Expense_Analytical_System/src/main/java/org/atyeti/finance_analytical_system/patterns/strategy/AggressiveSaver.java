package org.atyeti.finance_analytical_system.patterns.strategy;

import org.atyeti.finance_analytical_system.model.Transaction;

import java.util.List;

public class AggressiveSaver implements SavingsStrategy {
    @Override
    public String suggest(List<Transaction> t, double income) {
        return "Recommended: Save at least 40% of income. Cut non-essential expenses.";
    }
}
