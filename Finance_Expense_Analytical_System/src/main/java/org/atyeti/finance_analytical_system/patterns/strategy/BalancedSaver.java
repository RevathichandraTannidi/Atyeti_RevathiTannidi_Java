package org.atyeti.finance_analytical_system.patterns.strategy;
import org.atyeti.finance_analytical_system.model.Transaction;

import java.util.List;

public class BalancedSaver implements SavingsStrategy {

@Override
    public void suggest(List<Transaction> t, double income) {
        System.out.println("Save 20-30% and reduce expenses");
    }
}
