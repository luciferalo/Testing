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

    int amount;


    private int id;

    void setId (int id) {

        this.id = id;

    }

    @FXML
    void Backbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            HomeController homeController = loader.getController();
            homeController.setId(id);

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
    void Depositbtnclicked(ActionEvent event){
        amount = Integer.parseInt(Deposittxt.getText());
        Online_Bank.getClient(id).setTotal_balance(amount);
        DepositOutLabel.setText("your new balance is equals " +  (Online_Bank.getClient(id).getTotal_balance()));

//        try {
//            FXMLLoader loader;
//            loader = new FXMLLoader(getClass().getResource("LastPage.fxml"));
//            root = loader.load();
//
//            LastPageController lastPageController = loader.getController();
//
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
