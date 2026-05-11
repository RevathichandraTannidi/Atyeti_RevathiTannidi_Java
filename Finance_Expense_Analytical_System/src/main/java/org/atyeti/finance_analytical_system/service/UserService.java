package org.atyeti.finance_analytical_system.service;

import org.atyeti.finance_analytical_system.exception.FinancialException;
import org.atyeti.finance_analytical_system.model.User;
import org.atyeti.finance_analytical_system.repository.UserRepository;

public class UserService {

    private UserRepository repo = new UserRepository();

    // CREATE USER
    public void createUser(User user) {

        if (user == null) {
            throw new FinancialException("User cannot be null");
        }

        if (user.getIncome() <= 0) {
            throw new FinancialException("Income must be positive");
        }

        if (user.getMonthlyBudget() <= 0) {
            throw new FinancialException("Budget must be positive");
        }

        repo.createUser(
                user.getId(),
                user.getName(),
                user.getIncome(),
                user.getMonthlyBudget()
        );
    }

    // GET USER
    public User getUser(int id) {

        User user = repo.getUserById(id);

        if (user == null) {
            throw new FinancialException("User not found");
        }

        return user;
    }

    // CHECK USER EXISTS
    public boolean userExists(int id) {
        return repo.userExists(id);
    }

    // DELETE USER
    public void deleteUser(int id) {
        repo.deleteUser(id);
    }

    // UPDATE USER
    public void updateUser(User user) {

        if (user.getIncome() <= 0) {
            throw new FinancialException("Income must be positive");
        }

        repo.updateUser(user);
    }
}