package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class TransferMoneyTest {

    private static Client client;
    private static Account account;
    private static Client DestinationClient;
    private static Account DestinationAccount;


    @BeforeClass
    public static void setUp() {
        System.out.println("\n=======setup Creation=============");
        client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        account = client.getAccounts(1);
        DestinationClient =new Client("youssef", "3432", "Male", "2793864", 1000, "1234", "joe");
        DestinationAccount=DestinationClient.getAccounts(1);
        System.out.println("===========setup Creation completed========");
    }


    @Test  // 3 functions used
    public void testTransferMoney() {           // integration testing using (withdraw.soruce , deposit.dest)
        client.transfer_money(account,DestinationAccount,500);
        assertEquals(500.0, account.get_balance(), 0.0);
        assertEquals(1500.0, DestinationAccount.get_balance(), 0.0);
        setUp();
    }

    @Test
    public void test_invalid_TransferMoney1() {   // insufficient funds
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.transfer_money(account, DestinationAccount, 1100);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }

    @Test
    public void test_invalid_TransferMoney2() {   // -ve value
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.transfer_money(account, DestinationAccount, -1100);
        });
        assertEquals("Invalid Withdraw Amount!", exception.getMessage());
    }

    @Test    // Advanced
    public void testTransferToNonExistentAccount() {
        Account nonExistentAccount = new Account(2, 0);      // initializing trash account
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.transfer_money(account, nonExistentAccount, 500.0);
        });
        assertEquals("Destination Account does not exist!", exception.getMessage());
        setUp();
    }
    @Test
    public void testPayBill() {
        client.pay_bill("Electricity", account, 100.0);
        assertEquals(900.0, client.getTotal_balance(), 0.0);
        setUp();
    }
}
