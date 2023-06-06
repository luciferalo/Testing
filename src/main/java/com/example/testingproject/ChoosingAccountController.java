package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChoosingAccountController {
    @FXML
    private Parent root;
    @FXML
    private Stage stage1;
    @FXML
    private Scene scene;
    @FXML
    private Button Logoutbtn;
    @FXML
    private Button Account2btn;

    @FXML
    private Button Account3btn;

    @FXML
    private Button Acount1btn;

    private int id;
    private int account_no;



    void setId(int id) {
        this.id =id;
    }

    @FXML
    void account1clicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            HomeController homeController1 = loader.getController();
            homeController1.setId(id,1);

            stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void account2clicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            HomeController homeController2 = loader.getController();
            homeController2.setId(id,2);

            stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void account3clicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            HomeController homeController3 = loader.getController();
            homeController3.setId(id,3);

            stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
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

            stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void acc1visibility (){
        Acount1btn.setVisible(false);
    }
    void acc2visibility (){
        Account2btn.setVisible(false);
    }
    void acc3visibility (){
        Account3btn.setVisible(false);
    }
}


