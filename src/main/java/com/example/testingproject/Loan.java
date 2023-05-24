package com.example.testingproject;

import java.time.LocalDate;

public class Loan {
    private static int id_counter = 0;
    private String id;
    private Client client;
    private double amount;
    private int duration;
    private double interest_rate;
    private boolean approved;
    private LocalDate date_approved;

    public Loan(Client client, double amount, int duration, double interest_rate) {
        this.client = client;
        this.amount = amount;
        this.duration = duration;
        this.interest_rate = interest_rate;
        this.approved = false;
        this.date_approved = null;
        this.id = "L" + id_counter;
        id_counter++;
    }

    public double get_monthly_payment() {
        double monthly_interest_rate = interest_rate / 12;
        double monthly_payment = amount * (monthly_interest_rate / (1 - Math.pow(1 + monthly_interest_rate, -duration)));
        return monthly_payment;
    }

    public void approve() {
        approved = true;
        date_approved = LocalDate.now();
    }

    public void deny() {
        approved = false;
    }

    public String get_id() {
        return id;
    }

    public Client get_client() {
        return client;
    }

    public double get_amount() {
        return amount;
    }

    public int get_duration() {
        return duration;
    }

    public double get_interest_rate(){
        return interest_rate;
    }

    public boolean is_approved() {
        return approved;
    }

    public LocalDate get_date_approved() {
        return date_approved;
    }
}