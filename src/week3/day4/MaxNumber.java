
package week3.day4;

import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements separated by comma: ");
        String input = sc.nextLine();
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            token = token.trim();
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
            }
        }
        if (numbers.isEmpty()) {
            System.out.println("No integers provided");
        } else {
            System.out.println(Collections.max(numbers));
        }
        sc.close();
    }
}

