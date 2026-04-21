package assessment;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Arya", 67));
        students.add(new Student(2, "Akhil", 88));
        students.add(new Student(3, "Arjun", 56));
        students.add(new Student(4, "David", 98));
        students.add(new Student(5, "Charles", 47));
        for (Student s : students) {
            System.out.println("ID:" + s.getId() + ", Name:" + s.getName() + ", Marks:" + s.getMarks());
        }
    }
}
