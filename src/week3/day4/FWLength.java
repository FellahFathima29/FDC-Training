package week3.day4;

import java.io.*;
import java.util.*;

public class FWLength {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\ffa\\\\Desktop\\Frequency\\t6.txt";
        Map<Integer, Integer> lengthCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.replaceAll("\\p{Punct}", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        int len = word.length();
                        lengthCountMap.put(len, lengthCountMap.getOrDefault(len, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
        }
        int maxCount = 0;
        for (int count : lengthCountMap.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        List<Integer> mostFrequentLength = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : lengthCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostFrequentLength.add(entry.getKey());
            }
        }

        System.out.print("Highest frequency length: ");
        boolean first = true;

        for (int num : mostFrequentLength) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(num);
            first = false;
        }
        System.out.println("\nCount: " + maxCount);
    }
}
