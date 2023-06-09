package com.example.testingproject;

public class Account {
    private  int id_counter = 0;
    private String id;
    private double balance;

static boolean is_there(Account a){
    return a.id_counter != 0;
}
    public Account( double initial_balance,int counter) {
        this.id_counter=counter;
        this.deposit(initial_balance);
        this.id =  "A" + id_counter;

    }

    public void deposit(double amount) {
        try {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successful Deposit and your balance is "+balance);
                new Deposit(this, amount);
            }
            else {
                System.out.println("Invalid Deposit Amount!");
                throw new IllegalArgumentException("Invalid Deposit Amount!");
            }
        }
        catch (IllegalArgumentException e ){
            //throw new IllegalArgumentException("Invalid Deposit Amount!");
            e.getMessage();
        }
    }

    public void withdraw(double amount) {
    if(amount<0){
        System.out.println("Exception<<Negative Amount!>>");
        throw new IllegalArgumentException("Invalid Withdraw Amount!");
    }
        if (balance < amount) {
            System.out.println("Insufficient funds!");
            System.out.println("Insufficient funds.");
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        System.out.println("Successful Withdraw and your balance is "+balance);
        new Withdraw(this, amount);
    }

    public void transfer_to(Account destination, double amount) {
        if (balance < amount) {
            System.out.println("Insufficient funds!");
            throw new IllegalArgumentException("Insufficient funds.");
        }
        if (!is_there(destination)){
            throw new IllegalArgumentException("Destination Account does not exist!");
        }
        if(amount<0){
            System.out.println("Exception<<Negative Amount!>>");
            throw new IllegalArgumentException("Invalid Withdraw Amount!");
        }
        System.out.println("--------------Source Client Notification: ");
        this.withdraw(amount);
        System.out.println("--------------Destination Client Notification: ");
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



