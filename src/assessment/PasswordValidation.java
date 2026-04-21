package assessment;

public class PasswordValidation {
    public static void main(String[] args) {
        try {
            PasswordValidation.validatePassword("xyz23");
            PasswordValidation.validatePassword("abcyzghjko");
        } catch (InvalidPasswordException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    static void validatePassword(String password) {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password length must not be less than 8");
        }
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }
    }
}

