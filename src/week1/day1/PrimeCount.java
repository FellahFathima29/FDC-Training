package week1.day1;

import java.util.Scanner;

public class PrimeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        int res = countPrimes(n);
        System.out.println("Number of primes between 1 and " + n + " is: " + res);
        sc.close();
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (PrimeCheck.isPrime(i)) {
                count++;
            }
        }
        return count;
    }
}




