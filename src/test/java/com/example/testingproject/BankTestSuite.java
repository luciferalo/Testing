package com.example.testingproject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MasterAdminTest.class,
        Client_DB_Suite.class,
        MoneyTransferTestSuite.class,

})
public class BankTestSuite {

}
