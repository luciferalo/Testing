package com.example.testingproject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClientBasicTest.class,
        ClientTransactionsTest.class
})
public class BankTestSuite {
    // empty class
}
