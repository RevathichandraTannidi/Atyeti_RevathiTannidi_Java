package com.ExpenseTracker.controller;


import com.ExpenseTracker.Service.ExpenseService;
import com.ExpenseTracker.model.Expense;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return service.getAllExpenses();
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    @GetMapping("/summary/{year}/{month}")
    public double getSummary(@PathVariable int year, @PathVariable int month) {
        return service.getMonthlySummary(year, month);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
    }
}
