package com.example.testingproject;

import javafx.scene.control.PasswordField;

import java.util.ArrayList;
import java.util.Scanner;
public class Online_Bank {
    Scanner input = new Scanner(System.in);
    public static ArrayList<Client> clients = new ArrayList<Client>();


Online_Bank(){
    this(false);
}



    Online_Bank(boolean start){
        if(start){  // initializer
            clients.add(new Client("youssef", "3432", "Male", "2793864", 1000, "1234", "joe"));
            clients.add(new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily"));
            clients.get(0).open_account(0);

            Online_Bank Bank = new Online_Bank();
        }
        /*if(!start){
       *//* System.out.println("1.Create a new Account");
        System.out.println("2.Login");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        if(choice == 1){
            createAccount();
            Online_Bank Bank = new Online_Bank();
        }else if(choice == 2) {
            login();
            Online_Bank Bank = new Online_Bank();
        }*//*
        }*/
}


    public boolean login(String username, String password){
        /*input.nextLine();
        System.out.print("Input username: ");
        String username = input.nextLine();
        System.out.print("Input password: ");
        String password = input.nextLine();*/

        for(Client c: clients){
            if(c.username.equals(username)){
                if(c.password.equals(password)){
                    //                                   c  = el specif client bta33y
                    //userPage(c);

                    // fxml event (c)
                    return true;

                } else {
                    System.out.println("Wrong password");
                    return false;
                }
            }
        }
        System.out.println("No username found");
        return false;
    }



    public void createAccount(){
        System.out.print("Input a [unique] username: ");
        input.nextLine();
        String username = input.nextLine();
        for(Client c:clients ){
            if(c.username.equals(username)){
                System.out.println("Username already taken");
                createAccount();
            }
        }
        System.out.print("enter your name: ");
        String name = input.nextLine();
        System.out.print("Gender: ");
        String gender = input.nextLine();
        System.out.print("Input NationalID: ");
        String id = input.nextLine();
        System.out.print("Enter your mobile number: ");
        String no = input.nextLine();
        System.out.print("Gender: ");
        String usr_gender = input.nextLine();
        System.out.print("Input password: ");
        String pass = input.nextLine();
        clients.add(new Client(name,id,usr_gender,no,0,pass,username));
    }

/*void userPage(Client c){
    Account destinationAcc;


    System.out.println("Welcome "+c.name+" ^^");
    *//*
    ur code to handle all Client implemented functions
     *//*

    destinationAcc=find_Client_Acc("joe","A1");
    if(!destinationAcc.is_there(destinationAcc))
        System.out.println("there is no account with this id :/");
    else{
        System.out.println("Account Found! id: ["+destinationAcc.get_id()+"]");
    }
   return;
}*/

Account find_Client_Acc(String usr_name,String Accid){           // for deliver destination (Acc) etc.......
    Account a=new Account(0,0);

    int id = (int) Accid.charAt(1) - (int) '0';
        for(Client c:clients ){
            if(c.username.equals(usr_name)){
                System.out.println("user_name ["+c.username +"] Found!");
                 a=c.getAccounts(id);
               return a;
            }
        }
        /*
        use method a.is_there(a)
         */

        return a;
}




                    ///            Sample Client
/*

    a1=c1.getAccounts(1);
        System.out.println("id of acc is "+a1.get_id());
        a1.deposit(1000);
        a1.withdraw(500);
    //a1.showbalance();

    a2=c1.getAccounts(2);
        System.out.println("id of acc is "+a2.get_id());
        a2.deposit(1000);
        a2.withdraw(500);
        System.out.println("the total balance = "+c1.getTotal_balance());


        System.out.println("Loan status of 900 = "+c1.apply_for_loan(900,"123"));
        System.out.println("the total balance = "+c1.getTotal_balance());
        System.out.println("Loan status of 150 = "+c1.apply_for_loan(150," 21"));
        System.out.println("the total balance = "+c1.getTotal_balance());
        System.out.println(c1.getVirtual_balance());
        System.out.println("Loan 1 of id: "+c1.getLoans(1).get_id()+" = "+c1.getLoans(1).get_amount());
    //System.out.println(c1.getLoans(2).get_amount());
        System.out.println("Total Loan = "+c1.getTotal_loan());
*/



}