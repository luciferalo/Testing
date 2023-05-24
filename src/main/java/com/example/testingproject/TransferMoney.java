package com.example.testingproject;

public class TransferMoney extends Transaction {
    private Account source;
    private Account destination;

    public TransferMoney(Account source, Account destination, double amount) {
        super(amount);
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String get_type() {
        return "transfer";
    }

    public Account get_source() {
        return source;
    }

    public Account get_destination() {
        return destination;
    }
}