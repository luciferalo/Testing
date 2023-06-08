package com.example.testingproject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClientOpenAccTest.class,
        ClientRegisterTest.class,
        ClientLoanTest.class
})
public class Client_DB_Suite {
}
