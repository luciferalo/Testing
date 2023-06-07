package com.example.testingproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Stage loginstage;
    private Scene loginscene;
    private Parent loginroot;

    private static int id;

    @FXML
    private Label failedlabel;
    @FXML
    private TextField Usertxt;

    @FXML
    private Button loginbtn;

    @FXML
    private PasswordField passwordtxt;

  static boolean start;


    public  void  setId (int id) {

        this.id = id;
    }

    Online_Bank text = new Online_Bank(false);

    @FXML
    void setLoginbtn(ActionEvent event) throws IOException {
        String UserName= Usertxt.getText();
        String pass= passwordtxt.getText();
        boolean login = text.login(UserName,pass);
        if (login){
    try {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("ChoosingAccount.fxml"));
        loginroot = loader.load();

        ChoosingAccountController choosingAccountController = loader.getController();
        choosingAccountController.setId(id);

        loginstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginscene = new Scene(loginroot);
        loginstage.setScene(loginscene);
        loginstage.show();
    }
    catch (Exception e){
        e.printStackTrace();
        }
    }
        else{
            failedlabel.setText("Invalid Username or Password ");
        }
    }

}

