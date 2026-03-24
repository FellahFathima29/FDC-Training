package week1.day2;

public class NetBanking extends Payment{
    public void pay(int amount){
        System.out.println("Paid "+ amount +" using Net Banking");
    }


    public void print(int amount) {
        System.out.println("Payment receipt generated for amount:"+amount);
    }


    public void refund(int amount) {
        System.out.println("Refunded "+amount+" using Net Banking");
    }
}


