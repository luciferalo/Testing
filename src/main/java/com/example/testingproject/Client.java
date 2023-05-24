package com.example.testingproject;

import java.util.ArrayList;

public class Client {
    String name;
    String nationalID;
    String mobile;


     Gender gender;
    public enum Gender {
        Male,
        Female
    }

    private ArrayList<Account> accounts;

    private ArrayList<Loan> loans;
    private Bank bank;

    Client(){


    }


    public Client(String name, String nationalID, Gender gender, String mobile) {
        accounts = new ArrayList<>();
        this.name = name;
        this.nationalID = nationalID;
        this.gender = gender;
        this.mobile = mobile;
    }

    public Account open_account(double initial_balance) {
        Account account=new Account(this,initial_balance);
        bank.add_account(account);
        accounts.add(account);
        return account;
    }

    public void close_account(Account account) {
        accounts.remove(account);
        bank.remove_account(account);
    }

 /*   public Loan apply_for_loan(double amount, int duration, double interest_rate) {
        return bank.open_loan(this, amount, duration, interest_rate);
    }
*/
    public void make_deposit(Account account, double amount) {
        account.deposit(amount);
        new Deposit(account, amount);
    }

    public void make_withdrawal(Account account, double amount) {
        account.withdraw(amount);
        new Withdraw(account, amount);
    }

    public void transfer_money(Account source, Account receiver, double amount) {
        source.transfer_to(receiver, amount);
        new TransferMoney(source, receiver, amount);
    }

    public void pay_bill(String biller, Account account, double amount) {
        account.withdraw(amount);
        new PayBills(biller, account, amount);
    }
}