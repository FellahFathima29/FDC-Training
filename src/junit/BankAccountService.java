package junit;

import java.util.HashMap;
import java.util.Map;

public class BankAccountService {
    private final Map<Integer, Double> acc = new HashMap<>();

    public void createAccount(int id, double initialBalance) {
        if (id <= 0) {
            throw new IllegalArgumentException("Account ID must be positive");
        }
        if (acc.containsKey(id)) {
            throw new IllegalArgumentException("Account ID must be unique");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be > 0");
        }
        acc.put(id, initialBalance);
    }

    public void deposit(int id, double amnt) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID found");
        }
        if (!acc.containsKey(id)) {
            throw new IllegalArgumentException("Account does not exist");
        }
        if (amnt <= 0) {
            throw new IllegalArgumentException("Deposit amount must be > 0");
        }
        acc.put(id, acc.get(id) + amnt);
    }

    public void withdraw(int id, double amnt) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid account ID");
        }
        if (amnt <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        double currentBalance = acc.get(id);
        if (amnt > currentBalance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        acc.put(id, currentBalance - amnt);
    }

    public double getBalance(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid account ID");
        }
        if (!acc.containsKey(id)) {
            throw new IllegalArgumentException("Account does not exist");
        }
        return acc.get(id);
    }

    public void clear() {
        acc.clear();
    }
}