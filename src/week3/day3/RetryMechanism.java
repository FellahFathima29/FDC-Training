
package week3.day3;

import java.util.Random;
import java.util.Scanner;

public class RetryMechanism {

    static Random random = new Random();

    public static void randomEvent() {
        Scanner sc = new Scanner(System.in);
        int maxRetries = 2;
        int retryCount = 0;

        while (true) {
            try {
                if (random.nextBoolean()) {
                    System.out.println("Success");
                    return;
                } else {
                    throw new RuntimeException("Random failure");
                }
            } catch (Exception e) {
                if (retryCount >= maxRetries) {
                    throw e;
                }
                retryCount++;
                System.out.println("Retry number: " + retryCount);
            }
        }
    }

    public void main() {
        randomEvent();
    }
}

