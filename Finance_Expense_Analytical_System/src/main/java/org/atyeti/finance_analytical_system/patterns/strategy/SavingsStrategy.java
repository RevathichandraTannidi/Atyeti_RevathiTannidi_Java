package org.atyeti.finance_analytical_system.patterns.strategy;

import org.atyeti.finance_analytical_system.model.Transaction;
import java.util.List;


public interface SavingsStrategy {
    void suggest(List<Transaction> transactions, double income);
}