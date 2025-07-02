package Interfacesj;

public class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println( amount + " via Credit Card");
    }
}
