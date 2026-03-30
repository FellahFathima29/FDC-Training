package week3.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements separated by comma:");
        String input = sc.nextLine();
        String[] tokens = input.split(",");
        List<String> List = new ArrayList<>();
        for (String token : tokens) {
            String trimmed = token.trim();
            boolean isDuplicate = false;
            for (String existing : List) {
                if (existing.equalsIgnoreCase(trimmed)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                List.add(trimmed);
            }
        }
        System.out.println("Unique values are: " + List);
        sc.close();
    }
}


