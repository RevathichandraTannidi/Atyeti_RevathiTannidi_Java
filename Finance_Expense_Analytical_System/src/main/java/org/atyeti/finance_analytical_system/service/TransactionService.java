package org.atyeti.finance_analytical_system.service;

import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.repository.TransactionRepository;
import org.atyeti.finance_analytical_system.exception.FinancialException;

import java.util.List;

public class TransactionService {

    private TransactionRepository repo = new TransactionRepository();

    public void addTransaction(Transaction t) {

        if (t == null) {
            throw new FinancialException("Transaction cannot be null");
        }

        if (t.getAmount() <= 0) {
            throw new FinancialException("Transaction amount must be greater than zero");
        }

        repo.addTransaction(t);
    }

    public List<Transaction> getUserTransactions(int userId) {
        return repo.getAllTransactions(userId);
    }
}