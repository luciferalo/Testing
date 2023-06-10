package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ShowAccountController {

    private int id;
    @FXML
    private Label Accbalancelabel;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button Backbtn;

//    @FXML
//    private Button Donebtn;

    @FXML
     private Label usernamelabel;
    @FXML
    private Label balancelabel;

    @FXML
    private Label genderlabel;

    @FXML
    private Label loanlabel;

    @FXML
    private Label mobilelabel;

    @FXML
    private Label nationalIdLabel;



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
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void displayAccountData (int id) {
        double balance = Online_Bank.getClient(id).getTotal_balance();
        String totalbalance = Double.toString(balance);
        double loan = Online_Bank.getClient(id).getTotal_loan();
        String totalloan = Double.toString(loan);
        double acc = Online_Bank.getClient(id).getAccounts(account_no).get_balance();
        String accbalande = Double.toString(acc);

        usernamelabel.setText(Online_Bank.getClient(id).name);
        nationalIdLabel.setText(Online_Bank.getClient(id).nationalID);
        genderlabel.setText(Online_Bank.getClient(id).gender);
        mobilelabel.setText(Online_Bank.getClient(id).mobile);
        balancelabel.setText(totalbalance);
        loanlabel.setText(totalloan);
        Accbalancelabel.setText(accbalande);
    }
}
