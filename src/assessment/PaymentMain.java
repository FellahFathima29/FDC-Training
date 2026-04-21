package assessment;

import java.util.Scanner;

public class PaymentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the payment type");
        System.out.println("1.CreditCard");
        System.out.println("2.UPI");
        System.out.println("3.Wallet");
        int ch = sc.nextInt();
        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        PaymentFailedException.PaymentMethod payment = null;
        try {
            switch (ch) {
                case 1:
                    System.out.println("Enter 16 digits Card number");
                    String card = sc.nextLine();
                    System.out.println("Enter 3 digits CVV");
                    String cvv = sc.nextLine();
                    payment = new CreditCardPayment(card, cvv);
                    break;
                case 2:
                    System.out.println("Enter UPI ID");
                    String upi = sc.nextLine();
                    payment = new UPIPayment(upi);
                    break;
                case 3:
                    System.out.println("Enter Wallet balance");
                    double balance = sc.nextDouble();
                    payment = new WalletPayment(balance);
                    break;
            }
            payment.pay(amount);
        } catch (PaymentFailedException e) {
            System.out.println("Payment Failed");
        }
    }

}

