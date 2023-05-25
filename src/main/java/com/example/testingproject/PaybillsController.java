package com.example.testingproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PaybillsController {

    @FXML
    private TextField Amunttxt;

    @FXML
    private ComboBox<String> ComboBoxtxt;

    @FXML
    private Button Paybtn;
    @FXML
    public void inisialize(URL url, ResourceBundle resourceBundle){
        ComboBoxtxt.setItems(FXCollections.observableArrayList("Electricity","Water","University fees","Gas"));
    }

}
