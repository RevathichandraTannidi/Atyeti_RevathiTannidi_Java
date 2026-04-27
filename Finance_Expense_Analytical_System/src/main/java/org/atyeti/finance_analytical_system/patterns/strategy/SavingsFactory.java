package org.atyeti.finance_analytical_system.patterns.strategy;

public class SavingsFactory {

    public static SavingsStrategy getStrategy(double income) {

        if (income > 100000) return new AggressiveSaver();
        else if (income > 50000) return new BalancedSaver();
        else return new ConservativeSaver();
    }
}