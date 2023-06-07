package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
public class RegPageController {

    @FXML
    private Button Donebtn;
    @FXML
    private RadioButton femalebtn;

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

    private String username = Usernametxt.getText();
    private String password = Passwordtxt.getText();
    private String nationalid = NationalIDtxt.getText();
    private String mobile = Mobiletxt.getText();
//    private String male = malebtn.getText();
//    private String female = femalebtn.getText();
    private String name = Nametxt.getText();


    @FXML
    void Regbtnclicked(ActionEvent event){
        if(malebtn.isSelected()) {
            Online_Bank.createAccount(name, nationalid, username, password, mobile, malebtn.getText());
        }
        else {
            Online_Bank.createAccount(name, nationalid, username, password, mobile, malebtn.getText());
        }
    }
}
