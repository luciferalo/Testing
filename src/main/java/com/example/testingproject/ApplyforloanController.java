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

public class ApplyforloanController {

    @FXML
    private Button Applybtn;
    @FXML
    private Parent root;
    @FXML
    private Button Logoutbtn;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button Backbtn;

    @FXML
    private Label Loanapprovedlabel;

    @FXML
    private Label Loandeniedlabel;

    @FXML
    private TextField Loantxt;
    @FXML
    private Label totallabel;

    int loanamount;

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
    void Applybtnclicked(ActionEvent event){
        loanamount = Integer.parseInt(Loantxt.getText());
        if(loanamount <= Online_Bank.getClient(id).getVirtual_balance() ) {
            Loanapprovedlabel.setText("Loan Approved and your new balance in account " + account_no + " equals " + (loanamount + Online_Bank.getClient(id).getAccounts(account_no).get_balance()));
            Loandeniedlabel.setText("");
            totallabel.setText("your new total balance is equal " + (loanamount + Online_Bank.getClient(id).getTotal_balance()));
            Online_Bank.getClient(id).setLoanamount(loanamount);
        }
        else {
            Loandeniedlabel.setText("Loan denied for insufficient balance. Your balance is " + Online_Bank.getClient(id).getTotal_balance());
            Loanapprovedlabel.setText("");
            totallabel.setText("");
        }
    }
}
