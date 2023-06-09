package com.example.testingproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.testingproject.Online_Bank.clients;

public class RegPageController implements Initializable {

    @FXML
    private Button Donebtn;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
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
    @FXML
    private Label errortxt;
    @FXML
    private ComboBox<String > genderbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderbox.setItems(FXCollections.observableArrayList("Male","Female"));
    }

    public boolean compare (String username){
        for(Client c: clients){
            if(c.username.equals(username))
                return false;
        }
        return true;
    }
    @FXML
    void Regbtnclicked(ActionEvent event) {
        String username = Usernametxt.getText();
        String password = Passwordtxt.getText();
        String nationalid = NationalIDtxt.getText();
        String mobile = Mobiletxt.getText();
        String gender = genderbox.getValue();
        String name = Nametxt.getText();
        if ( name == null || nationalid == null || gender == null || mobile == null || username == null || password == null) {

           errortxt.setText("please enter all the data required");
        }

        else if (name.isEmpty() || nationalid.isEmpty() || gender.isEmpty() || mobile.isEmpty() || username.isEmpty() || password.isEmpty())
            errortxt.setText("please enter all the data required");


        else {
            if(compare(username)) {

                try {
                    Online_Bank.createAccount(name, nationalid, username, password, mobile, gender);
                } catch (Exception e) {
                    e.printStackTrace();
                    errortxt.setText("Username already found");
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            errortxt.setText("Username already taken please enter another another username");
        }
    }

}
