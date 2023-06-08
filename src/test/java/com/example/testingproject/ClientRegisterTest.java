package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class ClientRegisterTest {
    private static Online_Bank MyBank;
    @BeforeClass
    public static void setUp() {
        System.out.println("\nBank Accounts Initialzer ");
        MyBank=new Online_Bank(true);
    }
    @Test
    public void RegisterTest() {
        MyBank.createAccount("test", "test","test", "test", "test", "Male");
        assertTrue(MyBank.Creation_flag);
        assertEquals(Online_Bank.clients.get(2).getTotal_balance(),1000,0);
        setUp();
    }
    @Test
    public void Register_Invalid_Test() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MyBank.createAccount("test", "testUsername","lily", "test", "test", "Female");
        });
        assertEquals("Username already taken", exception.getMessage());
        setUp();

    }
}
