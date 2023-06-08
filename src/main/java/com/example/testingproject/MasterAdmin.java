package com.example.testingproject;

import java.util.ArrayList;

public class MasterAdmin {
    String name;
    String nationalID;
    String mobile;
    String username;
    String SecurityCode;
    String gender;

    public MasterAdmin(String name, String nationalID, String gender, String mobile,String SecurityCode,String user_name) {
        this.SecurityCode=SecurityCode;
        this.username=user_name;
        this.name = name;
        this.nationalID = nationalID;
        this.gender = gender;
        this.mobile = mobile;
    }

    public void BanClient(String UsrName) {
        for(Client c: Online_Bank.clients){
            if(c.username.equals(UsrName)){
                Online_Bank.clients.remove(c);
                System.out.println("Client Successfully removed");
                return;
            }
        }
        System.out.println("Username not found!");
        throw new IllegalArgumentException("Username not found!");
    }

    public void BanClientAcc(String UsrName,int AccNo) {
        for(Client c: Online_Bank.clients){
            if(c.username.equals(UsrName)){
                Account a=c.getAccounts(AccNo);
                if(a.is_there(a)){
                c.close_account(AccNo);
                System.out.println("Account Successfully Banned");
                return;
                }
                else{
                    System.out.println("Account not found!");
                    throw new IllegalArgumentException("Account Not Found!");
                }
            }
        }
        System.out.println("Username not found!");
        throw new IllegalArgumentException("Username not found!");
    }


}
