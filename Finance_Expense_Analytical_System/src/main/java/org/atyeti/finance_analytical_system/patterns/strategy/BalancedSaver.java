package org.atyeti.finance_analytical_system.patterns.strategy;
import org.atyeti.finance_analytical_system.model.*;

import java.util.List;

public class BalancedSaver implements SavingsStrategy {
  @Override
    public String suggest(List<Transaction> transactions, double income) {
      return "Recommended: Save 20–30% of income and reduce discretionary spending.";

    }
}
