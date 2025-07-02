package Interfacesj;

public class payme {
    public static void main(String[] args) {
        PaymentContext con = new PaymentContext();

        con.setStrategy(new CreditCardPayment());
         con.makePayment(100);

        con.setStrategy(new PayPalPayment());
         con.makePayment(200);
    }
}
