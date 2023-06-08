package com.example.testingproject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DepositTest.class,
        TransferMoneyTest.class,
        WithdrawTests.class,
})
public class MoneyTransferTestSuite {
}
