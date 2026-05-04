package org.atyeti.finance_analytical_system.service;

import org.atyeti.finance_analytical_system.model.EMICalculator;

public class EMIService {

    private EMICalculator calculator = new EMICalculator();

    public void evaluateLoan(double income, double principal, double rate, int months) {

        double emi = calculator.calculateEMI(principal, rate, months);
        double total = calculator.totalPayment(emi, months);
        double interest = calculator.totalInterest(total, principal);
        System.out.println("\n===== Loan Analysis =====");
        System.out.println("Monthly EMI       : ₹" + Math.round(emi));
        System.out.println("Total Payment     : ₹" + Math.round(total));
        System.out.println("Total Interest    : ₹" + Math.round(interest));

        if (emi <= income * 0.4) {
            System.out.println("Status        :  Affordable");
        } else {
            System.out.println("Status        : Not Affordable");
        }
    }


}