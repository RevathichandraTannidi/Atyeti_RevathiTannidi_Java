package Exception;

public class Bank {

        private double balance;

        public Bank(double balance)
        {
            this.balance=balance;
        }

        private void withDraw(Double amount)
        {

                if(amount>balance)
                {
                    throw new InsufficientFundsException(" balance is negative");
                }
                balance-=amount;

        }


    public static void main(String[] args) {
    }
}
