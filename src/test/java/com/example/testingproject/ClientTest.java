package com.example.testingproject;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testOpenAccount() {
        Client client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        assertEquals(1, client.Num_Acc);
        assertEquals(1000.0, client.getTotal_balance(), 0.0);
    }

    @Test
    public void testMakeDeposit() {
        Client client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        Account account = client.getAccounts(1);
        client.make_deposit(account, 500.0);
        assertEquals(1500.0, client.getTotal_balance(), 0.0);
    }

    @Test
    public void testMakeWithdrawal() {
        Client client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
        Account account = client.getAccounts(1);
        client.make_withdrawal(account, 500.0);
        assertEquals(500.0, client.getTotal_balance(), 0.0);
    }

    @Test
    public void testTransferMoney() {
        Client client = new Client("youssef", "3432", "Male", "2793864", 1000, "1234", "joe");
        Account account1 = client.getAccounts(1);
        Account account2 = new Account(0.0, 2);
        client.transfer_money(account1, account2, 500.0);
        assertEquals(500.0, account1.get_balance(), 0.0);
        assertEquals(500.0, account2.get_balance(), 0.0);
    }

    @Test
    public void testPayBill() {
        Client client = new Client("youssef", "3432", "Male", "2793864", 1000, "1234", "joe");
        Account account = client.getAccounts(1);
        client.pay_bill("Electricity", account, 100.0);
        assertEquals(900.0, client.getTotal_balance(), 0.0);
    }

    @Test
    public void testApplyForLoan() {
        Client client = new Client("youssef", "3432", "Male", "2793864", 1000, "1234", "joe");
        assertTrue(client.apply_for_loan(500.0, "2023-06-30"));
        assertEquals(500.0, client.getTotal_loan(), 0.0);
        assertEquals(500.0, client.getVirtual_balance(), 0.0);
    }
}
