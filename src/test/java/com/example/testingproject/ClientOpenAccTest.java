package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class ClientOpenAccTest {
    private static Client client;

    @BeforeClass
    public static void setUp() {
        client = new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily");
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
        client.open_account(1000);// trying to create 4th Acc
        assertEquals(3, client.Num_Acc);  // accepted ,as it will not create the last account
        setUp();
    }


    @Test
    public void test_OpenAccount_ClientTB() {
        client.open_account(1000);
        assertEquals(2000.0, client.getTotal_balance(), 0.0);
        setUp();
    }

    @Test
    public void test_OpenAccount_Invalid_ClientTB() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.open_account(-1000);
        });
        assertEquals("Invalid Deposit Amount!", exception.getMessage());
        setUp();
    }



    @Test
    public void testAccountNum_close() {
        client.close_account(1);
        assertEquals(0, client.Num_Acc);
        setUp();
    }
}
