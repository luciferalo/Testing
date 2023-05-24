package com.example.testingproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button loginbtn;

    @FXML
    private PasswordField passwordtxt;

    @FXML
    private TextField usernametxt;

    @FXML
    void loginbtnClick(ActionEvent event) {
        System.out.println("hi");
    }

}
