package org.atyeti.finance_analytical_system.patterns.strategy;

import org.atyeti.finance_analytical_system.model.Transaction;

import java.util.List;

public class AggressiveSaver implements SavingsStrategy {
    @Override
    public void suggest(List<Transaction> t, double income) {
        System.out.println("Save at least 40% of income");
    }
}
