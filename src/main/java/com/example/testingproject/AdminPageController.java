package com.example.testingproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

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

    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        for (Client client : clients) {
            clientSelection.getItems().add(Online_Bank.getClient(client.getId()).username);
        }
    }


    @FXML
    void removeClientbtnClicked (ActionEvent event) {

            Online_Bank.Admin.BanClient(clientSelection.getValue());


    }

    @FXML

    void removeAccountbtnClicked (ActionEvent event) {

        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("AdminRemoveAccount.fxml"));
            root = loader.load();

            AdminRemoveAccountController adminRemoveAccountController = loader.getController();


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
