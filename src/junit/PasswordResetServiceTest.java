package junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Password Reset Service Test")
class PasswordResetServiceTest {
    static PasswordResetService service = new PasswordResetService();

    @BeforeAll
    public static void setup() {
    }

    @BeforeEach
    public void generateToken() {
        String token = service.generateToken("101");
        String token1 = service.generateToken("102");
    }

    @AfterEach
    public void clearDb() {
        service.clear();
    }

    @Test
    void testGenerateTokenNullUserId() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> service.generateToken(null));
        assertEquals("UserId cannot be null or empty", e.getMessage());
    }

    @Test
    void testGenerateTokenEmptyUserId() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> service.generateToken(""));
        assertEquals("UserId cannot be null or empty", e.getMessage());
    }

    @Test
    void testGenerateTokenUniqueTokens() {
        String token1 = service.generateToken("101");
        String token2 = service.generateToken("102");
        assertNotEquals(token1, token2);
    }

    @Test
    void testValidateTokenValid() {
        String token = service.generateToken("101");
        assertTrue(service.validateToken(token));
    }

    @Test
    void testValidateTokenInvalidToken() {
        InvalidTokenException ex = assertThrows(InvalidTokenException.class, () -> {service.validateToken("200");});
        assertEquals("Token is invalid", ex.getMessage());
    }


    @Test
    void testValidateTokenExpiredToken() {
        String token = service.generateToken("101");
        service.expireToken(token);
        InvalidTokenException e = assertThrows(InvalidTokenException.class, () -> service.validateToken(token));
        assertEquals("Token has expired", e.getMessage());
    }


    @Test
    void testResetPasswordSuccess() {
        String token = service.generateToken("101");
        boolean result = service.resetPassword(token, "Pass@123");
        assertTrue(result);
        InvalidTokenException e = assertThrows(InvalidTokenException.class, () -> service.validateToken(token));
        assertEquals("Token has expired", e.getMessage());
    }


    @Test
    void testResetPasswordInvalidToken() {
        InvalidTokenException e = assertThrows(InvalidTokenException.class, () -> service.resetPassword("156", "Pass@123"));
        assertEquals("Token is invalid ", e.getMessage());
    }


    @Test
    void testResetPasswordShortPassword() {
        String token = service.generateToken("101");
        InvalidPasswordException e = assertThrows(InvalidPasswordException.class, () -> service.resetPassword(token, "P@1"));
        assertEquals("Password must be at least 8 characters", e.getMessage());
    }


    @Test
    void testExpireTokenValidToken() {
        String token = service.generateToken("101");
        service.expireToken(token);
        Exception e = assertThrows(Exception.class, () -> service.validateToken(token));
        assertEquals("Token has expired", e.getMessage());
    }


    @Test
    void testExpireTokenInvalidTokenShouldIgnore() {
        Exception e = assertThrows(Exception.class, () -> service.expireToken("200"));
        assertEquals("Token has expired", e.getMessage());
    }


    @Test
    void testClearShouldRemoveAllTokens() {
        String token1 = service.generateToken("101");
        String token2 = service.generateToken("102");
        service.clear();
        assertThrows(InvalidTokenException.class, () -> {
            service.validateToken(token1);
        });
        assertThrows(InvalidTokenException.class, () -> {
            service.validateToken(token2);
        });
    }
}
