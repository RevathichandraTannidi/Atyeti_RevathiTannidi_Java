package conditionalStatements;

import java.util.Scanner;

public class LoanEligibilty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("\n");
        System.out.print("Are you currently employed? (true/false): ");
        boolean isEmployed = scanner.nextBoolean();
        System.out.print("Enter your credit score: ");
        int creditScore = scanner.nextInt();
        System.out.print("Enter your annual income: ");
        double annualIncome = scanner.nextDouble();
        System.out.print("Enter your existing debts: ");
        double existingDebts = scanner.nextDouble();
   if (age >= 21 && age <= 65) {
            if (isEmployed) {
                if (creditScore >= 700) {
                    if (annualIncome >= 50000) {
                        if (existingDebts < 20000) {
                            System.out.println("Loan Approved: Eligible for premium loan options.");
                        } else {
                            System.out.println("Loan Approved: Eligible for standard loan options.");
                        }
                    } else {
                        System.out.println("Loan Denied: Insufficient income.");
                    }
                } else {
                    System.out.println("Loan Denied: Poor credit score.");
                }
            } else {
                System.out.println("Loan Denied: Employment required.");
            }
        } else {
            System.out.println("Loan Denied: Age criteria not met.");
        }

        String loanType = (creditScore >= 750) ? "Premium Loan" :
                (creditScore >= 700) ? "Standard Loan" : "No Loan";
        System.out.println("Loan Type: " + loanType);

        scanner.close();
    }
}
