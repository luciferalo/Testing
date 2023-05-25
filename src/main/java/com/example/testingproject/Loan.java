package com.example.testingproject;

import java.time.LocalDate;

public class Loan {

    private String id;

    private double amount;
    private String duration;

    private boolean approved;


    public Loan(double amount, String duration,int counter) {
        this.amount = amount;
        this.duration = duration;
        this.approved = true;
        this.id = "L" + counter;
    }

    public String get_id() {
        return id;
    }


    public double get_amount() {
        return amount;
    }

    public String get_duration() {
        return this.duration;
    }



}