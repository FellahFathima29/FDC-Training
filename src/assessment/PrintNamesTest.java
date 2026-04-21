package assessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrintNamesTest {
    @BeforeEach
    void setUp(){
    }
    @Test
    void testNames(){
        List<String> input = Arrays.asList("Arya","Vishnu","Arjun","Charles");
        assertTrue(input.contains("Arya"));
        assertTrue(input.contains("Arjun"));
    }
}
