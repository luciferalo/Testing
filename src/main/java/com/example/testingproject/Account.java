package com.example.testingproject;

public class Account {
    private  int id_counter = 0;
    private String id;
    private double balance;

static boolean is_there(Account a){
    if(a.id_counter != 0){
        System.out.println("\nDestination Account does exist ^^");
    return true;
    }else{
        System.out.println("\nDestination Account does not exist!");
        return false;
    }
    //return a.id_counter != 0;
}
    public Account( double initial_balance,int counter) {
        this.id_counter=counter;
        this.deposit(initial_balance);
        this.id =  "A" + id_counter;

    }

    public void deposit(double amount) {
                long nano_startTime = System.nanoTime();
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
            throw new IllegalArgumentException("Invalid Deposit Amount!");
        }
          long nano_endTime = System.nanoTime();
         System.out.println("Time taken in nano seconds: "
                           + (nano_endTime - nano_startTime));
    }

    public void withdraw(double amount) {
                long nano_startTime = System.nanoTime();
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
          long nano_endTime = System.nanoTime();
         System.out.println("Time taken in nano seconds: "
                           + (nano_endTime - nano_startTime));
    }

    public void transfer_to(Account destination, double amount) {
                long nano_startTime = System.nanoTime();
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
          long nano_endTime = System.nanoTime();
         System.out.println("Time taken in nano seconds: "
                           + (nano_endTime - nano_startTime));
    }

    public void  showbalance() {
                long nano_startTime = System.nanoTime();

        System.out.println("The account has "+ balance);
          long nano_endTime = System.nanoTime();
         System.out.println("Time taken in nano seconds: "
                           + (nano_endTime - nano_startTime));
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



