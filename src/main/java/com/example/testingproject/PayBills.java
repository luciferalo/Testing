package com.example.testingproject;

public class PayBills extends Transaction {
    private String biller;
    private Account account;

    public PayBills(String biller, Account account, double amount) {
        super(amount);
        this.biller = biller;
        this.account = account;
    }

    @Override
    public String get_type() {
        return "bill payment";
    }

    public String get_biller() {
        return biller;
    }

    public Account get_account() {
        return account;
    }
}
