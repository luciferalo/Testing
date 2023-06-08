package com.example.testingproject;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class MasterAdminTest {
    static MasterAdmin admin;
    static Online_Bank b1;
    @BeforeClass
    public static void setUp() {
        admin=new MasterAdmin("Omar","3333","Male","+20 1020...","1q2w3e4r","masteradmin");
        System.out.println("\nBank Accounts Initialzer:- ");
         b1=new Online_Bank(true);
    }

    @Test
    public void BanClient() {
        admin.BanClient("joe");
        setUp();
    }

    @Test
    public void BanClient_notExist() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            admin.BanClient("Ana De Armas");
        });
        assertEquals("Username not found!", exception.getMessage());
        setUp();
    }

    @Test
    public void BanClientAccount() {
        admin.BanClientAcc("joe",1);
        setUp();
    }
}
