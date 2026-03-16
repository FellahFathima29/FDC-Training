package week1.day2;

public class CreditCard extends Payment{

    @Override
    public void pay(int amount) {
        System.out.println("Paid "+ amount +" using Credit Card");
    }

    @Override
    public void print(int amount) {
        System.out.println("Payment receipt generated for amount:" + amount);
    }

    @Override
    public void refund(int amount) {
        System.out.println("Refunded "+ amount +" using Credit Card");
    }
}
