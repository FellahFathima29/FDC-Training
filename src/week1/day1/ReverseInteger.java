package week1.day1;

import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        int rev = reverseDigits(num);
        System.out.println("Reversed number: " + rev);
        sc.close();
    }

    public static int reverseDigits(int n) {
        int r = 0;
        while (n != 0) {
            int digit = n % 10;
            r = r * 10 + digit;
            n = n / 10;
        }
        return r;
    }
}
