package assessment;

public class UPIPayment implements PaymentFailedException.PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;

    }

    public void pay(double amount) throws PaymentFailedException {
        if (!upiId.contains("@")) {
            throw new PaymentFailedException("Invalid UPI ID");
        }
        System.out.println("Paid " + amount + " using UPI");
    }

    public String getPaymentType() {
        return "UPI";
    }
}
