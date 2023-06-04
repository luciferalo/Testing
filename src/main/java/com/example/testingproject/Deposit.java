package com.example.testingproject;

public class Deposit extends Transaction {
    private Account account;

    public Deposit(Account account, double amount) {
        super(amount);
        this.account = account;
    }

    @Override
    public String get_type() {
        return "deposit";
    }

    public Account get_account() {
        return account;
    }
}



