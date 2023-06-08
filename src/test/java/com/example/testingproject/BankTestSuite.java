package com.example.testingproject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClientLoanTest.class,
        ClientOpenAccTest.class,
        DepositTest.class,
        TransferMoneyTest.class,
        WithdrawTests.class
})
public class BankTestSuite {

}
