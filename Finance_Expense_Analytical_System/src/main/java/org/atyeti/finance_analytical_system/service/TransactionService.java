package org.atyeti.finance_analytical_system.service;


import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    private TransactionRepository repo = new TransactionRepository();

    public void addTransaction(Transaction t) {
        if (t.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        repo.addTransaction(t);
    }

    public List<Transaction> getUserTransactions(int userId) {
        return repo.getAllTransactions(userId);
    }
}