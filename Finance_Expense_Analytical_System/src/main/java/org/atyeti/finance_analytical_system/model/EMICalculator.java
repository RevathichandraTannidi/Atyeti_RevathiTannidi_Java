package org.atyeti.finance_analytical_system.model;


public class EMICalculator {

    public double calculateEMI(double principal, double annualRate, int months) {
        double r = annualRate / (12 * 100);

        return (principal * r * Math.pow(1 + r, months)) /
                (Math.pow(1 + r, months) - 1);
    }

    public double totalPayment(double emi, int months) {
        return emi * months;
    }

    public double totalInterest(double total, double principal) {
        return total - principal;
    }
}
