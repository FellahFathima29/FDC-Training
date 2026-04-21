package assessment;

import java.util.ArrayList;
import java.util.List;

public class PrintNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Arya");
        names.add("Vishnu");
        names.add("Arjun");
        names.add("Charles");
        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }
    }
}
