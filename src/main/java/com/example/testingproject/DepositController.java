package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DepositController {

    @FXML
    private Button Backbtn;

    @FXML
    private Label DepositOutLabel;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button Logoutbtn;
    @FXML
    private Button Depositbtn;

    @FXML
    private TextField Deposittxt;
    @FXML
    private Label DepositOutLabel1;

    int amount;


    private int id;
    private int account_no;

    void setId (int id,int account_no) {

        this.id = id;
        this.account_no = account_no;

    }

    @FXML
    void Backbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            HomeController homeController = loader.getController();
            homeController.setId(id,account_no);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Logoutbtnclicked(ActionEvent event){
        try {
            FXMLLoader loader;
            LoginController.start=false;
            loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = loader.load();

            LoginController loginController = loader.getController();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void  Depositbtnclicked(ActionEvent event) {
        Account account = Online_Bank.getClient(id).getAccounts(account_no);
        amount = Integer.parseInt(Deposittxt.getText());
            if(amount > 0){
                Online_Bank.getClient(id).make_deposit(account , amount);
                DepositOutLabel.setText("your new balance in account " + account_no + " is equal " +  (Online_Bank.getClient(id).getAccounts(account_no).get_balance()));
                DepositOutLabel1.setText("your total balance is equals " + (Online_Bank.getClient(id).getTotal_balance()));
            }
            else {
                DepositOutLabel.setText("Invalid Deposit amount. Please enter a valid integer.");
                DepositOutLabel1.setText("");
            }
    }
//    void Depositbtnclicked(ActionEvent event){
//        try{
//            amount = Integer.parseInt(Deposittxt.getText());
//            if(amount >0 ){
//            Online_Bank.getClient(id).getAccounts(account_no).set_balance(amount);
//               Online_Bank.getClient(id).setVirtual_balance(-1*amount);
//            DepositOutLabel.setText("your new balance in account " + account_no + "is equal " +  (Online_Bank.getClient(id).getAccounts(account_no).get_balance()));
//            DepositOutLabel1.setText("your total balance is equals " + (Online_Bank.getClient(id).getTotal_balance()));
//            }
//            else {
//                DepositOutLabel1.setText("invalid amount please enter a positive value");
//            }
//        }
//        catch (NumberFormatException e) {
//            // show error message if input is not a valid integer
//            DepositOutLabel.setText("Invalid Deposit amount. Please enter a valid integer.");
//            DepositOutLabel1.setText("");
//        }
//    }

}
