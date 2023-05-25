package com.example.testingproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private Label label;

    public void displayname(String username) {
        label.setText("hello:" + username);
    }
}
