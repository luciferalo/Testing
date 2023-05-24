package com.example.testingproject;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Loan> loans;

    public Bank() {
        accounts = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void add_account(Account account) {
        accounts.add(account);
    }

    public void remove_account(Account account) {
        accounts.remove(account);
    }

    public Loan open_loan(Client client, double amount, int duration, double interest_rate) {
        Loan loan = new Loan(client, amount, duration, interest_rate);
        loans.add(loan);
        return loan;
    }

    public void close_loan(Loan loan) {
        loans.remove(loan);
    }

    public Account get_account_by_id(String account_id) {
        for (Account account : accounts) {
            if (account.get_id().equals(account_id)) {
                return account;
            }
        }
        return null;
    }

    public Loan get_loan_by_id(String loan_id) {
        for (Loan loan : loans) {
            if (loan.get_id().equals(loan_id)) {
                return loan;
            }
        }
        return null;
    }
}