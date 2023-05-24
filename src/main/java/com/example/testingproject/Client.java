package com.example.testingproject;

import java.util.ArrayList;

public class Client {
    private ArrayList<Account> accounts;
    private Bank bank;

    public Client(Bank bank) {
        accounts = new ArrayList<>();
        this.bank = bank;
    }

    public Account open_account(String account_type, double initial_balance) {
        Account account;

        if (account_type.equals("checking")) {
            account = new CheckingAccount(this, initial_balance);
        } else if (account_type.equals("savings")) {
            account = new SavingsAccount(this, initial_balance);
        } else {
            throw new IllegalArgumentException("Invalid account type.");
        }

        bank.add_account(account);
        accounts.add(account);
        return account;
    }

    public void close_account(Account account) {
        accounts.remove(account);
        bank.remove_account(account);
    }

    public Loan apply_for_loan(double amount, int duration, double interest_rate) {
        return bank.open_loan(this, amount, duration, interest_rate);
    }

    public void make_deposit(Account account, double amount) {
        account.deposit(amount);
        new Deposit(account, amount);
    }

    public void make_withdrawal(Account account, double amount) {
        account.withdraw(amount);
        new Withdraw(account, amount);
    }

    public void transfer_money(Account source, Account destination, double amount) {
        source.transfer_to(destination, amount);
        new TransferMoney(source, destination, amount);
    }

    public void pay_bill(String biller, Account account, double amount) {
        account.withdraw(amount);
        new PayBills(biller, account, amount);
    }
}