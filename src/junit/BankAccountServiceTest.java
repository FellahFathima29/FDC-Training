package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Bank Account Service Test")
public class BankAccountServiceTest {
    static BankAccountService service = new BankAccountService();

    @BeforeAll
    public static void setup() {
    }

    @BeforeEach
    public void setupAccounts() {
        service.createAccount(1, 1000.0);
        service.createAccount(2, 500.0);
    }

    @AfterEach
    public void clearDb() {
        service.clear();
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 100.0, 'Account ID must be positive'",
            "1, 100.0, 'Account ID must be unique'",
            "20, -200, 'Initial balance must be > 0'",
    })

    public void testCreateAccount(int id, double initialBalance, String errorMessage) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.createAccount(id, initialBalance));
        assertEquals(errorMessage, e.getMessage());
    }

    @Test
    void testCreateAccountSuccess() {
        service.createAccount(3, 200.0);
        assertEquals(200.0, service.getBalance(3));
    }

    @Test
    @DisplayName("Test Get Balance - ID 1")
    public void testGetBalance() {
        double balance = service.getBalance(1);
        assertEquals(1000.0, balance);
    }

    @Test
    public void testInvalidIdGetBalance() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.getBalance(-1));
        assertEquals("Invalid account ID", e.getMessage());
    }

    @Test
    @DisplayName("Test Duplicate Account ID")
    public void testDuplicateAccount() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.createAccount(1, 100.0));
        assertEquals("Account ID must be unique", e.getMessage());
    }

    @Test
    public void testNegativeInitialBalance() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.createAccount(5, -100.0));
        assertEquals("Initial balance must be > 0", e.getMessage());
    }

    @Test
    public void testDeposit() {
        service.deposit(1, 200.0);
        assertEquals(1200.0, service.getBalance(1));
    }

    @Test
    public void testInvalidDepositAmount() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.deposit(1, -50.0));
        assertEquals("Deposit amount must be > 0", e.getMessage());
    }

    @Test
    public void testDepositInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.deposit(9, 500.0));
        assertEquals("Account does not exist", e.getMessage());
    }

    @Test
    public void testWithdraw() {
        service.withdraw(1, 200.0);
        assertEquals(800.0, service.getBalance(1));
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.withdraw(2, 1000.0));
        assertEquals("Insufficient balance", e.getMessage());
    }

    @Test
    public void testInvalidWithdrawAmount() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.withdraw(1, -20.0));
        assertEquals("Withdraw amount must be positive", e.getMessage());
    }

    @Test
    void testWithdrawInvalidAccount() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.withdraw(-2, 5000.0));
        assertEquals("Invalid account ID", e.getMessage());
    }

    @Test
    void testGetBalanceInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.getBalance(99));
        assertEquals("Account does not exist", e.getMessage());
    }
}
