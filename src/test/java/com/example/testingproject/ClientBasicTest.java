package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class ClientBasicTest {
    private static Client client;
    private static Account account;

    @BeforeClass
    public static void setUp() {
        client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        account = client.getAccounts(1);
    }

    @Test
    public void testAccountNum_open() {
        client.open_account(1000);
        client.open_account(1000);
        assertEquals(3, client.Num_Acc);
        setUp();
    }
    @Test
    public void testAccount_invalid_Num_open() {   // exceded number of accounts
        client.open_account(1000);
        client.open_account(1000);
        client.open_account(1000);
        assertEquals(3, client.Num_Acc);  // as it will not create the last account
        setUp();
    }
    @Test
    public void testAccountNum_close() {
        client.close_account(1);
        assertEquals(0, client.Num_Acc);
        setUp();
    }
    @Test
    public void test_OpenAccount_ClientTB() {
        client.open_account(1000);
        assertEquals(2000.0, client.getTotal_balance(), 0.0);
        setUp();
    }

    @Test
    public void testVirtualBalance() {
        client.apply_for_loan(700,"2023-06-30");
        client.apply_for_loan(200,"2023-06-30");
        assertEquals(100, client.getVirtual_balance(), 0.0);
        assertEquals(1000, client.getTotal_balance(), 0.0);
        setUp();
    }

    @Test
    public void testLoanAmmount() {
        client.apply_for_loan(500,"2023-06-30");
        client.apply_for_loan(500,"2023-06-30");
        client.apply_for_loan(500,"2023-06-30");  // not accepted :/

        assertEquals(1000, client.getTotal_loan(), 0.0);
        assertEquals(0, client.getVirtual_balance(), 0.0);
        setUp();
    }
    @Test
    public void testLoanValidity_accpeted() {
        assertTrue(client.apply_for_loan(700,"2023-06-30"));
        assertEquals(300, client.getVirtual_balance(), 0.0);
        setUp();
    }
    @Test
    public void testLoanValidity_not_accpeted() {
        assertFalse(client.apply_for_loan(1100,"2023-06-30"));
        assertEquals(client.getTotal_balance(), client.getVirtual_balance(), 0.0);
        setUp();
    }
}
