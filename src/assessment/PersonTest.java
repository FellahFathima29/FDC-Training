package assessment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void testSetNameAndGetName() {
        String name = "Arya";
        person.setName(name);
        assertEquals(name, person.getName(), "The name should match the value set.");
    }

    @Test
    void testSetAgeAndGetAge() {
        int age = 28;
        person.setAge(age);
        assertEquals(age, person.getAge(), "The age should match the value set.");
    }
}
