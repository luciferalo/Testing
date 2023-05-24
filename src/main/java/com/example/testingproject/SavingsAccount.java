package com.example.testingproject;

public class SavingsAccount extends Account {
    public SavingsAccount(Client owner, double initial_balance) {
        super(owner, initial_balance);
    }

    @Override
    public String get_type() {
        return "savings";
    }
}