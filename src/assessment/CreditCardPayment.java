package assessment;

public class CreditCardPayment implements PaymentFailedException.PaymentMethod {
    private String cardNumber;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public void pay(double amount) throws PaymentFailedException {
        if (cardNumber.length() != 16 && cvv.length() != 3) {
            throw new PaymentFailedException("Invalid Card Details");
        }
        System.out.println("Paid " + amount + " using Credit Card");
    }

    public String getPaymentType() {
        return "Credit Card";
    }
}
