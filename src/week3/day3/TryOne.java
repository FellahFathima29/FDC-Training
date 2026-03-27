//package week3.day3;
//
//
//import java.util.*;
//
//public class TryOne {
//    public static void main(String[] args) {
//
//        String[] input = {"10", "20", "abc", "40"};
//
//        String validNumbers = "";
//        String invalidInputs = "";
//
//        for (String value : input) {
//            try {
//                int number = Integer.parseInt(value);
//                if (!validNumbers.isEmpty()) {
//                    validNumbers += ", ";
//                }
//                validNumbers += number;
//            } catch (NumberFormatException e) {
//                if (!invalidInputs.isEmpty()) {
//                    invalidInputs += ", ";
//                }
//                invalidInputs += value;
//            }
//        }
//        System.out.println("Valid numbers: " + validNumbers);
//        System.out.println("Invalid input: " + invalidInputs);
//    }
//}
//
//
//
package week3.day3;

import java.util.*;

public class TryOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values separated by comma:");
        String inputLine = scanner.nextLine();
        String[] i = inputLine.split(",");
        String validNumbers = "";
        String invalidInputs = "";

        for (String value : i) {
            try {
                int number = Integer.parseInt(value);
                if (!validNumbers.isEmpty()) {
                    validNumbers += ",";
                }
                validNumbers += number;
            } catch (NumberFormatException e) {
                if (!invalidInputs.isEmpty()) {
                    invalidInputs += ",";
                }
                invalidInputs += value;
            }
        }

        System.out.println("Valid numbers: " + validNumbers);

        if (invalidInputs.isEmpty()) {
            System.out.println("No invalid input");
        } else {
            System.out.println("Invalid input: " + invalidInputs);
        }

        scanner.close();
    }
}