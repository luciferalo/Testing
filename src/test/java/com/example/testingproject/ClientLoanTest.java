package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientLoanTest {
    private static Client client;
    private static Account account;

    @BeforeClass
    public static void setUp() {
        System.out.println("\n=======setup Creation=============");
        client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        account = client.getAccounts(1);
        System.out.println("===========setup Creation completed========");
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
    public void PayLoanTest_accepted() {
        client.apply_for_loan(700,"2023-06-30");
        System.out.println(client.num_loan);
        client.pay_loan(1, account);
        assertEquals(300, client.getTotal_balance(), 0.0); // client have money to pay loan and Loan removed
        setUp();
    }

    @Test
    public void PayLoan_NUM_Test_accepted() {
        client.apply_for_loan(700,"2023-06-30");
        System.out.println(client.num_loan);
        client.pay_loan(1, account);
        assertEquals(0, client.num_loan, 0.0); // client have money to pay loan and Loan removed
        setUp();
    }
    @Test
    public void PayLoanTest_invalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.apply_for_loan(700,"2023-06-30");
            client.make_withdrawal(account,500); // total balance = 500
            client.pay_loan(1, account);     // invalid because 500 < 700
        });
        assertEquals("Insufficient funds.", exception.getMessage());
        setUp();
    }
    @Test
    public void testLoanValidity_not_accpeted() {
        assertFalse(client.apply_for_loan(1100,"2023-06-30"));
        assertEquals(client.getTotal_balance(), client.getVirtual_balance(), 0.0);
        setUp();
    }
}
