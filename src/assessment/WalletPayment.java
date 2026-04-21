package assessment;

public class WalletPayment implements PaymentFailedException.PaymentMethod {
    private double balance;

    public WalletPayment(double balance) {
        this.balance = balance;

    }

    public void pay(double amount) throws PaymentFailedException {
        if (balance < amount) {
            throw new PaymentFailedException("Insufficient wallet balance");
        }
        System.out.println("Paid " + amount + " using Wallet");
    }

    public String getPaymentType() {
        return "Wallet";
    }
}
