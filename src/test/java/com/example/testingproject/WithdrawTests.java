package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class WithdrawTests {
    private static Client client;
    private static Account account;




    @BeforeClass
    public static void setUp() {
        client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        account = client.getAccounts(1);
    }


    @Test
    public void test_Accepted_Withdrawal() {
        client.make_withdrawal(account, 500.0);
        assertEquals(500.0, client.getTotal_balance(), 0.0);
        setUp();
    }
    @Test
    public void test_invalid_Withdrawal1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.make_withdrawal(account, 1100);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
        setUp();
    }

    @Test
    public void test_invalid_Withdrawal3() {   // - ve number
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.make_withdrawal(account, -500);
        });
        assertEquals("Invalid Withdraw Amount!", exception.getMessage());
        setUp();
    }





}
