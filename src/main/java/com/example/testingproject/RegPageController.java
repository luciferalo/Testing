package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegPageController {

    @FXML
    private Button Donebtn;
    @FXML
    private RadioButton femalebtn;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    private RadioButton malebtn;
    @FXML
    private TextField Mobiletxt;

    @FXML
    private TextField Nametxt;

    @FXML
    private TextField NationalIDtxt;

    @FXML
    private PasswordField Passwordtxt;

    @FXML
    private TextField Usernametxt;

//    private String username = Usernametxt.getText();
//    private String password = Passwordtxt.getText();
//    private String nationalid = NationalIDtxt.getText();
//    private String mobile = Mobiletxt.getText();
////    private String male = malebtn.getText();
////    private String female = femalebtn.getText();
//    private String name = Nametxt.getText();


    @FXML
    void Regbtnclicked(ActionEvent event){
        String username = Usernametxt.getText();
        String password = Passwordtxt.getText();
        String nationalid = NationalIDtxt.getText();
        String mobile = Mobiletxt.getText();
//      String male = malebtn.getText();
//      String female = femalebtn.getText();
        String name = Nametxt.getText();
        if(malebtn.isSelected()) {
            Online_Bank.createAccount(name, nationalid, username, password, mobile, malebtn.getText());
        }
        else {
            Online_Bank.createAccount(name, nationalid, username, password, mobile, femalebtn.getText());
        }
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = loader.load();

            LoginController loginController = loader.getController();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
