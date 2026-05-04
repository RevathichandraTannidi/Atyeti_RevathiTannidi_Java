package org.atyeti.finance_analytical_system.model;

import org.atyeti.finance_analytical_system.exception.FinancialException;

public class EMICalculator {

    public double calculateEMI(double principal, double annualRate, int months) {


        if (months <= 0) {
            throw new FinancialException("Loan duration must be greater than 0 months");
        }

        if (principal <= 0) {
            throw new FinancialException("Principal amount must be positive");
        }

        if (annualRate < 0) {
            throw new FinancialException("Interest rate cannot be negative");
        }

        //  Handle zero interest case
        if (annualRate == 0) {
            return principal / months;
        }

        double r = annualRate / (12 * 100);

        return (principal * r * Math.pow(1 + r, months)) /
                (Math.pow(1 + r, months) - 1);
    }

    public double totalPayment(double emi, int months) {

        if (months <= 0) {
            throw new FinancialException("Months must be greater than 0");
        }

        return emi * months;
    }

    public double totalInterest(double total, double principal) {

        if (total < principal) {
            throw new FinancialException("Total payment cannot be less than principal");
        }

        return total - principal;
    }
}