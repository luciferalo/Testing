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

    @FXML

    private  Button addaccountbutn;

    private int id;
    private int account_no;
    private boolean button2visible;



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
    void addaccbtnclicked(ActionEvent event){
       Online_Bank.getClient(id).open_account(0);
       if( Online_Bank.getClient(id).checkAccountExists(2))
           acc2visibility(true);

       if(Online_Bank.getClient(id).checkAccountExists(3))
           acc3visibility(true);

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

    //void acc1visibility (boolean flag){
        //Acount1btn.setVisible(flag);
    //}
    void acc2visibility (boolean flag){
        Account2btn.setVisible(flag);

    }
    void acc3visibility (boolean flag){
        Account3btn.setVisible(flag);
    }
//    boolean acc2visibility (){
//        Account2btn.setVisible(true);
//        return true;
//    }
//    boolean acc3visibility (){
//        Account3btn.setVisible(true);
//        return true;
//    }
}


