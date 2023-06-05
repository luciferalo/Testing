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


    private int id;

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
    private Button ChangeAccbtn;


    int account_no;


    void setId (int id, int account_no) {

        this.id = id;
        this.account_no = account_no;

    }

    @FXML
    void depositbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Deposit.fxml"));
            root = loader.load();

            DepositController depositController = loader.getController();
            depositController.setId(id,account_no);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void withdrawbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Withdraw.fxml"));
            root = loader.load();

            WithdrawController withdrawController = loader.getController();
            withdrawController.setId(id,account_no);


            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void transferbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Transfer.fxml"));
            root = loader.load();

            TransferController transferController = loader.getController();
            transferController.setId(id,account_no);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Applyforloadbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("ApplyForLoan.fxml"));
            root = loader.load();

            ApplyforloanController applyforloanController = loader.getController();
            applyforloanController.setId(id,account_no);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Paybillsbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Paybills.fxml"));
            root = loader.load();

            PaybillsController paybillscontroller = loader.getController();
            paybillscontroller.setId(id,account_no);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showaccountbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("ShowAccount.fxml"));
            root = loader.load();

            ShowAccountController showaccountcontroller = loader.getController();
            showaccountcontroller.setId(id,account_no);
            showaccountcontroller.displayAccountData(id);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ChangeAccbtnclicked(ActionEvent event){
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("ChoosingAccount.fxml"));
            root = loader.load();

            ChoosingAccountController choosingAccountController = loader.getController();
            choosingAccountController.setId(id);

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


}
