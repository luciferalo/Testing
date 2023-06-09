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
import javafx.fxml.Initializable;

public class PaybillsController implements Initializable{

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
    private String combotext;

    private int id;

    private int account_no;

    void setId (int id,int account_no) {

        this.id = id;
        this.account_no = account_no;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ComboBoxtxt.setItems(FXCollections.observableArrayList("Electricity","Water","University fees","Gas", "loan"));
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
        try {
            amount = Integer.parseInt(Amunttxt.getText());
            combotext = ComboBoxtxt.getValue();
            if (amount > 0) {
                if (amount <= Online_Bank.getClient(id).getAccounts(account_no).get_balance()) {
                        if(combotext==null){
                            Denied.setText("please specify the company you want to pay your bills to");
                        }
                        else {
                            Online_Bank.getClient(id).pay_bill(combotext, Online_Bank.getClient(id).getAccounts(account_no), amount);
                            Approve.setText("Approved and your new balance is equals " + (Online_Bank.getClient(id).getAccounts(account_no).get_balance()));
                            totalbalancelabel.setText("your total balance is equals " + Online_Bank.getClient(id).getTotal_balance());
                            Denied.setText("");
                        }
                    }
                }
            else {
                Denied.setText("Invalid amount. Please enter a positive integer.");
                Approve.setText("");}

        }
        catch (NumberFormatException E) {

            Denied.setText("Invalid amount. Please enter a valid integer.");
            Approve.setText("");

        }
        }
    }

