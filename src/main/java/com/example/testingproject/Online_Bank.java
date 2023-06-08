package com.example.testingproject;

import java.util.ArrayList;
import java.util.Scanner;
public class Online_Bank {
    static Scanner input = new Scanner(System.in);
    public static ArrayList<Client> clients = new ArrayList<Client>();
    static boolean Creation_flag=true;

Online_Bank(){
    this(false);
}
    Online_Bank(boolean start){
        if(start){  // initializer
            clients.add(new Client("youssef", "3432", "Male", "2793864", 1000, "1234", "joe"));
            clients.add(new Client("layla", "0912","Female", "01927237", 1000, "1234", "lily"));
            MasterAdmin Admin=new MasterAdmin("Omar","3333","Male","+20 1020...","1q2w3e4r","masteradmin");
             LoginController.start=false;
        }
}


    public static boolean login(String username, String password){


        for(Client c: clients){
            if(c.username.equals(username)){
                if(c.password.equals(password)){
                    //                                   c  = el specif client bta33y
                    //userPage(c);

                  LoginController g = new LoginController();
                    LoginController.start=false;
                     g.setId(c.getId());

                    // fxml event (c)

                    return true;

                } else {
                    System.out.println("Wrong password");
                    LoginController.start=false;
                    return false;
                }
            }
        }
        System.out.println("No username found");
        LoginController.start=false;
        return false;
    }

    public static void createAccount(String name , String ID , String username , String password , String mobile , String gender){

        for(Client c:clients ){
            if(c.username.equals(username)){
                Creation_flag=false;
                System.out.println("username aleady taken!");
                throw new IllegalArgumentException("Username already taken");
            }
        }
        System.out.println("user ["+ username + "] added to the system successfully");
        clients.add(new Client(name,ID,gender,mobile,0,password,username));
    }


static Account find_Client_Acc(String usr_name,String Accid){           // for deliver destination (Acc) etc.......

        Account a=new Account(0,0);

    int id = (int) Accid.charAt(1) - (int) '0';
        for(Client c:clients ){
            if(c.username.equals(usr_name)){
                System.out.println("user_name ["+c.username +"] Found!");
                 a=c.getAccounts(id);
               return a;
            }
        }
        return null;
}

public static Client find_Receiver (String name) {

    for(Client c:clients ){
        if(c.username.equals(name)){
           return c;
        }
    }
    return null;
}
    public static Client getClient (int id ) {

        return clients.get(id);
    }

}