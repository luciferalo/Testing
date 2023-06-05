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

public class TransferController {

    @FXML
    private TextField Accountnotxt;
    @FXML
    private Button Backbtn;
    @FXML
    private Button Logoutbtn;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private TextField amounttxt;

    @FXML
    private Label approvelabel;

    @FXML
    private Label failedlabel;

    @FXML
    private TextField nameofusertxt;

    @FXML
    private Button transferbtn;

    int amount;
    public String name;


    private int id;

    private int account_no;

    void setId (int id,int account_no) {

        this.id = id;
        this.account_no = account_no;

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
    void Backbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            HomeController homeController = loader.getController();

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
    void Transeferbtnclicked(ActionEvent event){
        amount= Integer.parseInt(amounttxt.getText());
        if(amount <= 1000 ) {
            approvelabel.setText("Transfer completed and your new balance is equal to " + (1000-amount));
            failedlabel.setText("");
        }
        else {
            failedlabel.setText("Transfer failed due to insufficient balance");
            approvelabel.setText("");
        }
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
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
