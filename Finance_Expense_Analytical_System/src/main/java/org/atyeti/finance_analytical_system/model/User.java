package org.atyeti.finance_analytical_system.model;


public class User {
    private int id;
    private String name;
    private double income;
    private double monthlyBudget;

    public User() {}

    public User(int id, String name, double income, double monthlyBudget) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.monthlyBudget = monthlyBudget;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }

    public double getMonthlyBudget() { return monthlyBudget; }
    public void setMonthlyBudget(double monthlyBudget) { this.monthlyBudget = monthlyBudget; }
}