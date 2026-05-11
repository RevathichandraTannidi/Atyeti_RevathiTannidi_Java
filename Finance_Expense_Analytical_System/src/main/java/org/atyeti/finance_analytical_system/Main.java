package org.atyeti.finance_analytical_system;

import org.atyeti.finance_analytical_system.concurrent.AlertScheduler;
import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.model.User;
import org.atyeti.finance_analytical_system.patterns.strategy.SavingsFactory;
import org.atyeti.finance_analytical_system.patterns.strategy.SavingsStrategy;
import org.atyeti.finance_analytical_system.repository.UserRepository;
import org.atyeti.finance_analytical_system.service.*;
import org.atyeti.finance_analytical_system.util.ReportGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // OBJECT CREATION
        UserService userService = new UserService();
        TransactionService ts = new TransactionService();

        BudgetAnalysisService bs = new BudgetAnalysisService();
        EMIService emiService = new EMIService();
        ReportGenerator report = new ReportGenerator();
        AlertScheduler scheduler = new AlertScheduler();
        FinancialInsightService fs = new FinancialInsightService();
        RiskAnalysisService rs = new RiskAnalysisService();

        System.out.println("===== Welcome to WealthPilot =====");

        // USER LOGIN / REGISTRATION
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        // CHECK USER EXISTS
        if (!userService.userExists(userId)) {

            System.out.println("\nNew User Detected!");

            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Monthly Income: ");
            double incomeInput = sc.nextDouble();

            System.out.print("Enter Monthly Budget: ");
            double budget = sc.nextDouble();

            User newUser = new User(
                    userId,
                    name,
                    incomeInput,
                    budget
            );

            userService.createUser(newUser);

            System.out.println("User created successfully!");
        }

// FETCH USER
        User user = userService.getUser(userId);

        double income = user.getIncome();

        System.out.println("\n===== User Details =====");
        System.out.println("Name    : " + user.getName());
        System.out.println("Income  : ₹" + user.getIncome());
        System.out.println("Budget  : ₹" + user.getMonthlyBudget());

        // MAIN LOOP
        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Spending Summary");
            System.out.println("4. EMI Calculator");
            System.out.println("5. Savings Advice");
            System.out.println("6. Generate Monthly Report");
            System.out.println("7. Start Budget Alerts");
            System.out.println("8. Financial Insight & Risk Analysis");
            System.out.println("0. Exit");

            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ADD TRANSACTION
                case 1:

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category =
                            sc.nextLine().toLowerCase().trim();

                    ts.addTransaction(
                            new Transaction(
                                    userId,
                                    amount,
                                    category,
                                    LocalDate.now()
                            )
                    );

                    System.out.println("Transaction added successfully!");
                    break;

                // VIEW TRANSACTIONS
                case 2:

                    List<Transaction> list =
                            ts.getUserTransactions(userId);

                    System.out.println("\n===== Transactions =====");

                    if (list.isEmpty()) {
                        System.out.println("No transactions found.");
                        break;
                    }

                    list.forEach(t ->
                            System.out.println(
                                    t.getCategory()
                                            + " - ₹"
                                            + t.getAmount()
                                            + " - "
                                            + t.getDate()
                            )
                    );

                    break;

                // SPENDING SUMMARY
                case 3:

                    list = ts.getUserTransactions(userId);

                    if (list.isEmpty()) {
                        System.out.println("No spending data available.");
                        break;
                    }

                    bs.printSummary(list);

                    break;

                // EMI CALCULATOR
                case 4:

                    System.out.print("Enter Loan Amount: ");
                    double principal = sc.nextDouble();

                    System.out.print("Enter Interest Rate: ");
                    double rate = sc.nextDouble();

                    System.out.print("Enter Tenure (months): ");
                    int months = sc.nextInt();

                    emiService.evaluateLoan(
                            income,
                            principal,
                            rate,
                            months
                    );

                    break;

                // SAVINGS ADVICE
                case 5:

                    list = ts.getUserTransactions(userId);

                    SavingsStrategy strategy =
                            SavingsFactory.getStrategy(income);

                    System.out.println("\n===== Savings Advice =====");

                    System.out.println(
                            strategy.suggest(list, income)
                    );

                    break;

                // MONTHLY REPORT
                case 6:

                    list = ts.getUserTransactions(userId);

                    if (list.isEmpty()) {
                        System.out.println("No report data available.");
                        break;
                    }

                    report.generateMonthlyReport(list, income);

                    break;

                // BUDGET ALERTS
                case 7:

                    list = ts.getUserTransactions(userId);

                    scheduler.start(
                            list,
                            user.getMonthlyBudget()
                    );

                    System.out.println(
                            "Budget alert system started..."
                    );

                    break;

                // FINANCIAL INSIGHT
                case 8:

                    list = ts.getUserTransactions(userId);

                    int score =
                            fs.calculateFinancialScore(user, list);

                    System.out.println(
                            "\n===== Financial Insight ====="
                    );

                    System.out.println(
                            "Financial Score : "
                                    + score
                                    + "/100"
                    );

                    System.out.println(
                            "Status : "
                                    + fs.getScoreRemark(score)
                    );

                    rs.detectRisk(user, list);

                    break;

                // EXIT
                case 0:

                    System.out.println(
                            "Exiting WealthPilot..."
                    );

                    sc.close();

                    System.exit(0);

                    // INVALID
                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}