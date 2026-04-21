package assessment;

import assessment.InvalidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidationTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void testShortPassword() {
        InvalidPasswordException e = assertThrows(InvalidPasswordException.class, () -> PasswordValidation.validatePassword("abc23"));
        assertEquals("Password length must not be less than 8", e.getMessage());
    }

    @Test
    void testPasswordNoDigit() {
        InvalidPasswordException e = assertThrows(InvalidPasswordException.class, () -> PasswordValidation.validatePassword("mjikolpedfo"));
        assertEquals("Password must contain at least one digit", e.getMessage());
    }
}