package org.atyeti.finance_analytical_system;

import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.patterns.strategy.SavingsFactory;
import org.atyeti.finance_analytical_system.patterns.strategy.SavingsStrategy;
import org.atyeti.finance_analytical_system.service.*;
import org.atyeti.finance_analytical_system.util.ReportGenerator;
import org.atyeti.finance_analytical_system.concurrent.AlertScheduler;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TransactionService ts = new TransactionService();
        BudgetAnalysisService bs = new BudgetAnalysisService();
        EMIService emiService = new EMIService();
        ReportGenerator report = new ReportGenerator();

        System.out.println("===== Welcome to WealthPilot  =====");

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter Monthly Income: ");
        double income = sc.nextDouble();

        AlertScheduler scheduler = new AlertScheduler();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Spending Summary");
            System.out.println("4. EMI Calculator");
            System.out.println("5. Savings Advice");
            System.out.println("6. Generate Monthly Report");
            System.out.println("7. Start Budget Alerts");
            System.out.println("0. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    ts.addTransaction(new Transaction(userId, amount, category, LocalDate.now()));
                    System.out.println(" Transaction added");
                    break;

                case 2:
                    List<Transaction> list = ts.getUserTransactions(userId);
                    System.out.println("\n===== Transactions =====");
                    list.forEach(t ->
                            System.out.println(t.getCategory() + " - ₹" + t.getAmount() + " - " + t.getDate())
                    );
                    break;

                case 3:
                    list = ts.getUserTransactions(userId);
                    bs.printSummary(list);
                    break;

                case 4:
                    System.out.print("Enter Loan Amount: ");
                    double principal = sc.nextDouble();

                    System.out.print("Enter Interest Rate: ");
                    double rate = sc.nextDouble();

                    System.out.print("Enter Tenure (months): ");
                    int months = sc.nextInt();

                    emiService.evaluateLoan(income, principal, rate, months);
                    break;

                case 5:
                    list = ts.getUserTransactions(userId);
                    SavingsStrategy strategy = SavingsFactory.getStrategy(income);
                    System.out.println(strategy.getClass().getSimpleName());
                    System.out.println("\n===== Savings Advice =====");
                    System.out.println( strategy.suggest(list, income));
                    break;

                case 6:
                    list = ts.getUserTransactions(userId);
                    report.generateMonthlyReport(list, income);
                    break;

                case 7:
                    list = ts.getUserTransactions(userId);
                    scheduler.start(list, 5000);
                    System.out.println(" Budget alert system started...");
                    break;

                case 0:
                    System.out.println(" Exiting WealthPilot...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println(" Invalid choice");
            }
        }
    }
}