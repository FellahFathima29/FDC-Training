static class InvalidPasswordException extends RuntimeException {
    InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordValidation {
    static void validatePassword(String password) {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password length must not be less than 8");
        }
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }
    }
}

public static void main(String[] args) {
    try {

        PasswordValidation.validatePassword("xyzcvg");

        PasswordValidation.validatePassword("dfghjuk");

        PasswordValidation.validatePassword("abc23456");
    } catch (InvalidPasswordException e) {
        System.out.println("Error:" + e.getMessage());
    }
}
