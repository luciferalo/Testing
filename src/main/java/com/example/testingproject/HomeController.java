package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Label label;
    @FXML
    private Button aflbtn;
    @FXML
    private Button depositbtn;
    @FXML
    private Button paybillsbtn;
    @FXML
    private Button showaccountbtn;
    @FXML
    private Button transferbtn;
    @FXML
    private Button withdrawbtn;

@FXML
void depositbtnclicked(ActionEvent event){
    try {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("Deposit.fxml"));
        root = loader.load();

        DepositController depositController = loader.getController();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    catch (Exception e) {
        e.printStackTrace();
        }

    }

    @FXML
    void withdrawbtnclicked(ActionEvent event){
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Withdraw.fxml"));
            root = loader.load();

            WithdrawController withdrawController = loader.getController();

            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
