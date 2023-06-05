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
        this.name = name;
        this.nationalID = nationalID;
        this.gender = gender;
        this.mobile = mobile;
        this.open_account(initial_balance);
        this.id = Client.clientId;
        Client.clientId++;

        System.out.println(id);




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
            this.Total_loan=this.getLoans(i).get_amount()+this.Total_loan;
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

    public boolean apply_for_loan(double amount,String Deadline){
        if(this.getVirtual_balance()<amount){
            System.out.println("your request is not accepted :/");
            return false;
        }
        else{

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
        new PayBills(biller, account, amount);
    }

    public void open_account(double initial_balance) {             // add new account
        if (Num_Acc!=3){
            Account account=new Account(initial_balance,++this.Num_Acc);
            accounts.add(account);
        }else{
            System.out.println("you have exceded the maximum number of acounts!");
        }

    }



    public void close_account(int AccNum) {
        accounts.remove(this.getAccounts(AccNum));
        this.Num_Acc--;
    }

    //--------------------------------------------------------------------------------------------------------
}