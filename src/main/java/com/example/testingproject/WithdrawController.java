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

public class WithdrawController {

    private int id;

    @FXML
    private Label approvedlabel;
    @FXML
    private Button Logoutbtn;
    @FXML
    private Button Backbtn;

    @FXML
    private Label failedlabel;

    @FXML
    private Button withdrawbtn;

    @FXML
    private TextField withdrawtxt;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    int amount;


    private int account_no;

    void setId (int id,int account_no) {

        this.id = id;
        this.account_no = account_no;

    }

    @FXML
    void withdrawbtnclicked(ActionEvent event) {
        try {
            amount = Integer.parseInt(withdrawtxt.getText());
            if (amount > 0) {
                if (amount <= 1000) {
                    approvedlabel.setText("Transaction is completed successfully and your new balance is "+ (1000-amount));
                    failedlabel.setText("");
                } else {
                    failedlabel.setText("Transaction failed due to insufficient balance. Your balance is " + 1000);
                    approvedlabel.setText("");
                }
            } else {
                // show error message if input is negative or zero
                failedlabel.setText("Invalid withdrawal amount. Please enter a positive value.");
                approvedlabel.setText("");
            }
        } catch (NumberFormatException e) {
            // show error message if input is not a valid integer
            failedlabel.setText("Invalid withdrawal amount. Please enter a valid integer.");
            approvedlabel.setText("");
        }
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
    void Logoutbtnclicked(ActionEvent event) {
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
}
