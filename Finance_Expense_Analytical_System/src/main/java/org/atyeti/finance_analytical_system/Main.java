package org.atyeti.finance_analytical_system;
import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.patterns.strategy.*;
import org.atyeti.finance_analytical_system.service.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TransactionService ts = new TransactionService();
        BudgetAnalysisService bs = new BudgetAnalysisService();

        ts.addTransaction(new Transaction(1, 500, "Food", LocalDate.now()));
        ts.addTransaction(new Transaction(1, 1200, "Rent", LocalDate.now()));

        List<Transaction> list = ts.getUserTransactions(1);

        System.out.println("Total: " + bs.getTotalSpending(list));
        System.out.println("Category: " + bs.getSpendingByCategory(list));

        EMIService emiService = new EMIService();
        emiService.evaluateLoan(50000, 500000, 10, 60);

        SavingsStrategy strategy = SavingsFactory.getStrategy(60000);
        strategy.suggest(list, 60000);
    }
}