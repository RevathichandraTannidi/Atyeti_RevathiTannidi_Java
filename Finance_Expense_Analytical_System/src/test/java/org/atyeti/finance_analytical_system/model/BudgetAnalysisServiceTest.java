package org.atyeti.finance_analytical_system.model;

import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.service.BudgetAnalysisService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetAnalysisServiceTest {

    @Test
    void testTotalSpending() {
        BudgetAnalysisService service = new BudgetAnalysisService();

        List<Transaction> list = List.of(
                new Transaction(1, 500, "Food", LocalDate.now()),
                new Transaction(1, 1500, "Rent", LocalDate.now())
        );

        double total = service.getTotalSpending(list);

        assertEquals(2000, total);
    }

    @Test
    void testSpendingByCategory() {
        BudgetAnalysisService service = new BudgetAnalysisService();

        List<Transaction> list = List.of(
                new Transaction(1, 500, "Food", LocalDate.now()),
                new Transaction(1, 500, "Food", LocalDate.now()),
                new Transaction(1, 1000, "Rent", LocalDate.now())
        );

        Map<String, Double> result = service.getSpendingByCategory(list);

        assertEquals(1000, result.get("Food"));
        assertEquals(1000, result.get("Rent"));
    }
}