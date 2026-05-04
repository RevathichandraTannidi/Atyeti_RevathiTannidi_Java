package org.atyeti.finance_analytical_system.patterns.strategy;

import org.atyeti.finance_analytical_system.model.Transaction;

import java.util.List;

public class ConservativeSaver implements SavingsStrategy {

    @Override
    public String suggest(List<Transaction> transactions, double income) {
        return "Recommended: Start with saving 10% and track spending habits.";
    }
}