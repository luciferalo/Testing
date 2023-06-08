package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class DepositTest {
    private static Client client;
    private static Account account;

    @BeforeClass
    public static void setUp() {
        client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        account = client.getAccounts(1);
    }

    @Test
    public void testDeposit() {
        client.make_deposit(account, 1000.0);
        assertEquals(2000.0, client.getTotal_balance(), 0.0);
        setUp();
    }
    @Test   // Advanced
    public void testNegativeDeposit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.make_deposit(account, -500.0);

        });
        assertEquals("Invalid Deposit Amount!", exception.getMessage());
        setUp();
    }

}
