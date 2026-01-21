
package oops.oopsGFG;

public class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double openingBalance) {
        if (accountNumber <= 0) {
            throw new IllegalArgumentException("Account number must be positive.");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + " | New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds. Available: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | New balance: " + balance);
    }

    @Override
    public String toString() {
        return "BankAccount{accountNumber=" + accountNumber + ", balance=" + balance + "}";
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(101, 1000.0);
        System.out.println(acc);

        acc.deposit(500.0);      // Balance -> 1500.0
        acc.withdraw(200.0);     // Balance -> 1300.0

        // Uncomment to see exception handling:
        // acc.deposit(-10);      // IllegalArgumentException
        // acc.withdraw(5000);    // IllegalStateException

        System.out.println("Final balance: " + acc.getBalance());
    }
}
