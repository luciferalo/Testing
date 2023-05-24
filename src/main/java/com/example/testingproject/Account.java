package com.example.testingproject;

public class Account {
    private static int id_counter = 0;
    private String id;
    private double balance;
    private Client owner;

    String username;
    String password;

    public Account(Client owner, double initial_balance) {
        this.owner = owner;
        this.balance = initial_balance;
        this.id = "A" + id_counter;
        id_counter++;
    }

    public void deposit(double amount) {
        balance += amount;
        new Deposit(this, amount);
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        new Withdraw(this, amount);
    }

    public void transfer_to(Account destination, double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        destination.deposit(amount);
        new TransferMoney(this, destination, amount);
    }

    public void  showbalance() {
        System.out.println("The account has"+ balance);
    }

    public double get_balance() {
        return balance;
    }


    public Client get_owner() {
        return owner;
    }

    public String get_id() {
        return id;
    }
}



