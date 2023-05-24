package com.example.testingproject;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Transaction {
    private String id;
    private double amount;
    private LocalDateTime date;

    public Transaction(double amount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public String get_id() {
        return id;
    }

    public abstract String get_type();

    public double get_amount() {
        return amount;
    }

    public LocalDateTime get_date() {
        return date;
    }
}
