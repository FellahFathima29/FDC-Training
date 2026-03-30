package week3.day4;

import java.util.*;

public class ApiValidation {
    public static String validateUsers(List<Map<String, Object>> users) throws Exception {
        Set<Integer> ids = new HashSet<>();
        for (Map<String, Object> user : users) {
            Object idObj = user.get("id");
            if (idObj == null) {
                throw new Exception("User ID cannot be null");
            }
            int id = (int) idObj;
            if (ids.contains(id)) {
                throw new Exception("Duplicate ID found: " + id);
            }
            ids.add(id);
            Object nameObj = user.get("name");
            if (nameObj == null) {
                throw new Exception("Invalid name for user ID: " + id);
            }
            Object emailObj = user.get("email");
            if (emailObj == null || !emailObj.toString().contains("@")) {
                throw new Exception("Invalid email for user ID: " + id);
            }
        }
        return "Validation successful";
    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", 1);
        map1.put("name", "John");
        map1.put("email", "john@test.com");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 2);
        map2.put("name", 123);
        map2.put("email", "arya@test.com");
        list.add(map1);
        list.add(map2);
        try {
            String result = validateUsers(list);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}

