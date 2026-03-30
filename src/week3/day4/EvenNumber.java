package week3.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter elements separated by comma: ");
        String input = sc.nextLine();
        String[] i = input.split(",");
        for (String in : i) {
            try {
                numbers.add(Integer.parseInt(in.trim()));
            } catch (NumberFormatException e) {
            }
        }
        List<Integer> evenNumbers = getEvenNumbers(numbers);
        if (evenNumbers.isEmpty()) {
            System.out.println("No even numbers provided");
        } else {
            System.out.println(evenNumbers);
        }
        sc.close();
    }

    static List<Integer> getEvenNumbers(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : list) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }
}
