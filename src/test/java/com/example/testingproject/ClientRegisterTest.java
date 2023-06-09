package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class ClientRegisterTest {
    private static Online_Bank MyBank;
    private static Client test;
    @BeforeClass
    public static void setUp() {
        System.out.println("\nBank Accounts Initialzer ");
        MyBank=new Online_Bank(true);
    }
    @Test
    public void RegisterTest_Paid() {
        Online_Bank.PaidMinDeposit=true;
        MyBank.createAccount("test", "test","test", "test", "test", "Male");
        assertTrue(MyBank.Creation_flag);
        test=Online_Bank.clients.get(2);
        assertEquals(test.getTotal_balance(),1000,0);
        setUp();
    }
    @Test
    public void RegisterTest_NotPaidAcc() {
        Online_Bank.PaidMinDeposit=false;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {

        MyBank.createAccount("test", "test","test1", "test", "test", "Male");
        assertTrue(MyBank.Creation_flag);
        test=Online_Bank.clients.get(2);

            assertEquals(test.getTotal_balance(),1000,0);
        });
        System.out.println("You didnt deposit the Minimum Balance!");
        assertEquals("Invalid Deposit Amount!", exception.getMessage());
        setUp();
    }
    @Test
    public void Register_Invalid_Test() {
        Online_Bank.PaidMinDeposit=true;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MyBank.createAccount("test", "testUsername","lily", "test", "test", "Female");
        });
        assertEquals("Username already taken", exception.getMessage());
        setUp();

    }
}
