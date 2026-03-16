package week1.day1;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        System.out.print("Enter fourth number: ");
        int d = sc.nextInt();
        System.out.print("Enter fifth number: ");
        int e = sc.nextInt();
        int largest = a;
        if (b > largest) largest = b;
        if (c > largest) largest = c;
        if (d > largest) largest = d;
        if (e > largest) largest = e;
        System.out.println("Largest number is: " + largest);
        sc.close();
    }
}