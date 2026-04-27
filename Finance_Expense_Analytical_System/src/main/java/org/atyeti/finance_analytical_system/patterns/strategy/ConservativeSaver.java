package org.atyeti.finance_analytical_system.patterns.strategy;

import org.atyeti.finance_analytical_system.model.Transaction;

import java.util.List;

public class ConservativeSaver implements SavingsStrategy {

    @Override
    public void suggest(List<Transaction> transactions, double income) {
        System.out.println("Start with saving 10%");
    }
}
