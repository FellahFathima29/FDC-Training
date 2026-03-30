package week3.day4;

import java.io.*;
import java.util.*;

public class Frequency {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ffa\\Desktop\\Frequency\\tc11.txt"));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = br.readLine()) != null) {
            content.append(line).append(" ");
        }
        br.close();
        findMostFrequentWord(content.toString());
    }

    public static void findMostFrequentWord(String text) {
        text = text.replaceAll("\\p{Punct}", "").toLowerCase();
        String[] words = text.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int maxFreq = 0;
        for (int count : map.values()) {
            if (count > maxFreq) {
                maxFreq = count;
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }
        System.out.println("Most repeated: " + String.join(", ", result));
        System.out.println("Frequency: " + maxFreq);
    }
}