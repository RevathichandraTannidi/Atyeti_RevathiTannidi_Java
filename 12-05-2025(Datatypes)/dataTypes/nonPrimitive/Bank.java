package dataTypes.nonPrimitive;

public class Bank {
    private int balance;

    public Bank(int initialBalance) {

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
        else{
            throw new IllegalArgumentException("Initial balance must be non-negative."); }

    }

    private void deposit(int amount)
    {
        if(amount>0)
         balance+=amount;
        else
            throw new IllegalArgumentException("add more amount to deposit");
    }
    private void withdraw(int amount)
    {
        if(amount>0)
            if(amount<=balance)
                balance-=amount;
            else
                throw new IllegalArgumentException("add more amount");

        else
            throw new IllegalArgumentException("insufficiet balance");
    }
    private int checkAmount()
    {
        return balance;
    }

    public static void main(String[] args) {
        Bank b=new Bank(1000);
        System.out.println("checking the current balance in the bank:"+ b.checkAmount());
       b.deposit(900);
        System.out.println("checking the current balance in the bank after deposit:"+ b.checkAmount());
        b.withdraw(372);
        System.out.println("checking the current balance in the bank after withdrawal:"+ b.checkAmount());



    }
}
