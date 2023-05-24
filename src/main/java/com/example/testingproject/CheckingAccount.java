package com.example.testingproject;

public class CheckingAccount extends Account {
    public CheckingAccount(Client owner, double initial_balance) {
        super(owner, initial_balance);
    }

    @Override
    public String get_type() {
        return "checking";
    }
}
