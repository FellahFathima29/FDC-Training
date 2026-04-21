package assessment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(1, "Arya", 67);
    }

    @Test
    void testStudentConstructorAndGetters() {
        assertAll("Verify Student properties",
                () -> assertEquals(1, student.getId(), "ID should match with input"),
                () -> assertEquals("Arya", student.getName(), "Name should match with input"),
                () -> assertEquals(67, student.getMarks(), "Marks should match with input")
        );
    }

    @Test
    void testList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Arya", 67));
        students.add(new Student(2, "Akhil", 88));
        students.add(new Student(3, "Arjun", 88));
        students.add(new Student(4, "David", 88));
        students.add(new Student(5, "Charles", 88));
        assertEquals(5, students.size(), "List should contain at least 5 students");
        assertEquals("Akhil", students.get(1).getName());
    }
}