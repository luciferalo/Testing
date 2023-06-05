package com.example.testingproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PaybillsController {

    @FXML
    private TextField Amunttxt;
    @FXML
    private Label Approve;
    @FXML
    private Button Backbtn;
    @FXML
    private ComboBox<String> ComboBoxtxt;
    @FXML
    private Label Denied;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Button Paybtn;
    @FXML
    private Button Logoutbtn;
    @FXML
    private Label totalbalancelabel;


    int amount;

    private int id;

    private int account_no;

    void setId (int id,int account_no) {

        this.id = id;
        this.account_no = account_no;

    }

    @FXML
    public void inisialize(URL url, ResourceBundle resourceBundle){
        ComboBoxtxt.setItems(FXCollections.observableArrayList("Electricity","Water","University fees","Gas"));
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
    void Backbtnclicked(ActionEvent event){
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
    void Paybtnclicked(ActionEvent event){
        amount = Integer.parseInt(Amunttxt.getText());
        if(amount <= Online_Bank.getClient(id).getAccounts(account_no).get_balance()) {
            Online_Bank.getClient(id).getAccounts(id).set_balance(-1*amount);
            Approve.setText("Approved and your new balance is equals " + (Online_Bank.getClient(id).getAccounts(account_no).get_balance()));
            totalbalancelabel.setText("your total balance is equals " + Online_Bank.getClient(id).getTotal_balance());
            Denied.setText("");
        }
        else {
            Denied.setText("Transaction denied duo to insufficient balance. Your balance is "+ Online_Bank.getClient(id).getAccounts(account_no).get_balance());
            Approve.setText("");
        }
    }
}
