package com.example.testingproject;

import java.util.ArrayList;

public class Client {
    String name;
    String nationalID;
    String mobile;
    String username;
    String password;
    String gender;

    private static int clientId=0;

    private int id;

    private double total_balance=0;
    private double virtual_balance=total_balance;

    private double Total_loan=0;




    Client(Client c){

    }
    private ArrayList<Account> accounts;

    private ArrayList<Loan> loans;
    int Num_Acc=0;
    int num_loan=0;
//----------------------------------------------------------------------------------------------------------------

    public Client(String name, String nationalID, String gender, String mobile,double initial_balance,String pass,String user_name) {
        this.password=pass;
        this.username=user_name;
        accounts = new ArrayList<>();
        loans=new ArrayList<>();
        this.open_account(initial_balance);
        this.name = name;
        this.nationalID = nationalID;
        this.gender = gender;
        this.mobile = mobile;
        this.id = Client.clientId;
        Client.clientId++;
       // System.out.println(id);
    }

    public int getId() {
        return this.id;
    }

    //----------------------------------------------------------------------------------------------------
    public Account getAccounts(int accno) {
        return this.accounts.get(accno-1);
    }
    public Loan getLoans(int num_loan) {
        return this.loans.get(num_loan-1);
    }


//------------------------------------------------------------------------------------------

    public double getTotal_loan() {
        this.Total_loan=0;
        for (int i = 1; i <=this.num_loan; i++) {
            this.Total_loan=  this.Total_loan + this.getLoans(i).get_amount();
        }
        return this.Total_loan;
    }

    public double getTotal_balance() {
        this.total_balance=0;
        for (int i = 1; i <=this.Num_Acc; i++) {
            total_balance=this.getAccounts(i).get_balance()+total_balance;
        }
        return total_balance;
    }

    public boolean apply_for_loan(double amount,String Deadline){
        if(this.getVirtual_balance()<amount){
            System.out.println("your request is not accepted :/");
            return false;
        }
        else{
            System.out.println("Loan approved!");
            Loan l=new Loan(amount,Deadline,++this.num_loan);
            loans.add(l);
            this.virtual_balance=this.virtual_balance-amount;
            return true;
        }

    }
    //-----------------------------------------------------------------------------------------------------------
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
        System.out.println("Thanks for Choosing Egy"+biller);
        new PayBills(biller, account, amount);
    }

    public void pay_loan(int loan_number, Account account) {
        double amount=this.getLoans(loan_number).get_amount();
        account.withdraw(amount);
        loans.get(loan_number-1);
        this.num_loan--;
        System.out.println("Loan Successfully Paid ^^");
    }

    public void open_account(double initial_balance) {             // add new account
        if(initial_balance<0) {
            System.out.println("Creating Account.....");
            System.out.println("Account Creation Failed :(");
            Account account = new Account(initial_balance, Num_Acc); // this will catch the exception ^^

        }
        if(initial_balance==0){
            if(Online_Bank.PaidMinDeposit){
                Num_Acc++;
                Account account = new Account(1000,Num_Acc);
                accounts.add(account);
            }else{
                System.out.println("Creating Account.....");
                System.out.println("Account Creation Failed :(");
                Account account = new Account(initial_balance, Num_Acc); // this will catch the exception ^^
            }
        }
        else if (this.Num_Acc<3) {

            //System.out.println("Account Creation....");
            Num_Acc++;
            Account account = new Account(initial_balance,Num_Acc);
            accounts.add(account);
           // System.out.println("Account Creaion completed ^^\n");

        } else{
            System.out.println("Invalid>>>You have exceded the maximum number of acounts!");
        }

    }

    boolean checkAccountExists (int accountId) {

        if (accountId < 0 || accountId> this.Num_Acc )
            return false;
        else
            return true;

    }



    public void close_account(int AccNum) {
        accounts.remove(this.getAccounts(AccNum));
        this.Num_Acc--;
    }


public double getVirtual_balance() {
    if(this.num_loan==0){
        this.virtual_balance=this.getTotal_balance();
    }
    else{
        this.virtual_balance=this.getTotal_balance()-this.getTotal_loan();
        System.out.println("loan = "+this.getTotal_loan()+"   total balance = "+this.getTotal_balance()+"  v.balance= "+ this.virtual_balance);

    }
    return this.virtual_balance;
}



}