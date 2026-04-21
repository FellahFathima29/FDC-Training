package assessment;

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }

    interface PaymentMethod {
        void pay(double amount) throws PaymentFailedException;

        String getPaymentType();
    }
}
