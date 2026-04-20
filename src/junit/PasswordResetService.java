package junit;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordResetService {

    private static class TokenInfo {
        String userId;
        boolean expired;

        TokenInfo(String userId) {
            this.userId = userId;
            this.expired = false;
        }
    }

    private final Map<String, TokenInfo> tokenStore = new HashMap<>();

    private long counter = 0;

    public synchronized String generateToken(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null or empty");
        }

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        String token = userId + "-" + timestamp.getTime() + "-" + (counter++);

        tokenStore.put(token, new TokenInfo(userId));
        return token;
    }

    public boolean validateToken(String token) {
        TokenInfo info = tokenStore.get(token);

        if (info == null) {
            throw new InvalidTokenException("Token is invalid");
        }

        if (info.expired) {
            throw new InvalidTokenException("Token has expired");
        }

        return true;
    }


    public boolean resetPassword(String token, String newPassword) {

        TokenInfo info = tokenStore.get(token);

        if (info == null) {
            throw new InvalidTokenException("Token is invalid ");
        }

        if (info.expired) {
            throw new InvalidTokenException("Token has expired");
        }

        if (newPassword == null || newPassword.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters");
        }

        if (!newPassword.matches(".*[!@#$].*")) {
            throw new InvalidPasswordException("Password must contain at least one special character !@#$");
        }

        if (!newPassword.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }

        info.expired = true;
        return true;
    }


    public void expireToken(String token) {
        TokenInfo info = tokenStore.get(token);

        if (info == null) {

            throw new InvalidTokenException("Token has expired");
        }

        info.expired = true;
    }


    public void clear() {
        tokenStore.clear();
        counter = 0;
    }
}