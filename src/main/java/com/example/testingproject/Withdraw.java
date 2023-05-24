package com.example.testingproject;

public class Withdraw extends Transaction {
    private Account account;

    public Withdraw(Account account, double amount) {
        super(amount);
        this.account = account;
    }

    @Override
    public String get_type() {
        return "withdrawal";
    }

    public Account get_account() {
        return account;
    }
}