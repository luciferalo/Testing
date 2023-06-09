package com.example.testingproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.testingproject.Online_Bank.clients;

public class AdminPageController implements Initializable {

    @FXML
    private Button RemoveAccountBtn;

    @FXML
    private Button RemoveClientBtn;

    @FXML
    private ComboBox<String> clientSelection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        for (Client client : clients) {
            clientSelection.getItems().add(Online_Bank.getClient(client.getId()).username);
        }
    }



    void removeClientbtnClicked (ActionEvent event) {




    }



}
