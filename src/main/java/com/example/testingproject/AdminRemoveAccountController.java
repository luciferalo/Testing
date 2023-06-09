package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.testingproject.Online_Bank.clients;

public class AdminRemoveAccountController {

    @FXML
    private ComboBox<String> AccountSelection;

    @FXML
    private Button RemoveBtn;



    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    //void setU


    //@Override
    //public void initialize(URL url, ResourceBundle resourceBundle){

   // }


    @FXML
    void removeClientbtnClicked (ActionEvent event) {



        int accountno = Integer.parseInt(AccountSelection.getValue());



        //Online_Bank.Admin.BanClientAcc(,accountno);


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
