package week1;


import week1.day2.*;
import week1.practiceimplements.CreditCard;
import week1.practiceimplements.*;
import week1.practiceimplements.NetBanking;
import week1.practiceimplements.Upi;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        // Scanner sc = new Scanner(System.in);
        //  System.out.println("Enter the type of vehicle");
        // String type = sc.nextLine();
        // if (type.equals("car")) {
        //   Car c = new Car();
        //  c.start();
        //  } else if (type.equals("bike")) {
        //    Bike b = new Bike();
        //  b.start();
        //  }

    //    Scanner sc = new Scanner(System.in);
     //   System.out.println("Enter the type of payment");
     //   String type = sc.nextLine();
      //  Payment payment;
     //   if (type.equals("CreditCard")) {
     //       payment = new CreditCard();
      //  } else if (type.equals("NetBanking")) {
        //    payment = new NetBanking();
      //  } else if (type.equals("UPI")) {
       //     payment = new Upi();
      //  } else{return;}
       // payment.pay(1000);
      //  payment.receipt(1000);
        //payment.refund(500);


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the type of payment");
        String type = sc.nextLine();
        PaymentNew paymentnew;
         paymentnew = new CreditCard();

        paymentnew = new NetBanking();

        paymentnew  = new Upi();

        paymentnew.pay(1000);

        paymentnew .refund(500);

        paymentnew.print(1000);
    }
}

