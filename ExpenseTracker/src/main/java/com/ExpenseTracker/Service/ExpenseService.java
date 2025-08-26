package com.ExpenseTracker.Service;

import com.ExpenseTracker.dao.ExpenseRepository;
import com.ExpenseTracker.model.Expense;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    public Expense addExpense(Expense expense) {
        if (expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        return repo.save(expense);
    }

    public double getMonthlySummary(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        return repo.findByDateBetween(start, end)
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }
}
