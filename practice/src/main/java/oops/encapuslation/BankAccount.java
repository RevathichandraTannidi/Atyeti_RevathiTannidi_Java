package oops.encapuslation;

public class BankAccount {
    private  int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int deposit(double amount)
    {
        if(amount>0)
       return balance+=amount;
        else
            throw new IllegalStateException("negative ammount");
    }
    public int withDraw(double amount)
    {
        if(amount>0)
        return balance-=amount;

        else
            throw new IllegalStateException("ngative amount not allowed");
    }
    public int getBalance()
    {
        if(balance>0)
            return balance;
        else
            throw new IllegalStateException("negative balance");
    }

    public static void main(String[] args) {
        BankAccount ba=new BankAccount(5000);
        System.out.println(ba.getBalance());
       ba.deposit(1000);
        System.out.println(ba.deposit(500));
        ba.withDraw(500);
        System.out.println("get balance :" + ba.getBalance());

    }
}
