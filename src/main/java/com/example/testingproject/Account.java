package com.example.testingproject;

public class Account {
    private  int id_counter = 0;
    private String id;
    private double balance;

boolean is_there(Account a){
    return a.id_counter != 0;
}
    public Account( double initial_balance,int counter) {
        this.id_counter=counter;
        this.balance = initial_balance;
        this.id =  "A" + id_counter;

    }

    public void deposit(double amount) {
    if(amount>0){
        balance += amount;
        new Deposit(this, amount);}
    else{
        System.out.println("Exception <<Invalid Deposit Amount!>>");
        throw new IllegalArgumentException("Invalid Deposit Amount!");
    }
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
        if (!is_there(destination)){
            throw new IllegalArgumentException("Destination Account does not exist!");
        }
        balance -= amount;
        destination.deposit(amount);
        new TransferMoney(this, destination, amount);
    }

    public void  showbalance() {
        System.out.println("The account has "+ balance);
    }

    public double get_balance() {
        return balance;
    }

    public void set_balance(double amount) {

        this.balance += amount;
    }




    public String get_id() {
        return id;
    }
}



