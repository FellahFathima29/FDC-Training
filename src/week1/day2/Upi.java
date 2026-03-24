package week1.day2;

public class Upi extends Payment{
    public void pay(int amount){
        System.out.println("Paid "+ amount+" using Upi");
    }


    public void print(int amount) {
        System.out.println("Payment receipt generated for amount:" +amount);
    }


    public void refund(int amount) {
        System.out.println("Refunded "+ amount+" using Upi");
    }
}


