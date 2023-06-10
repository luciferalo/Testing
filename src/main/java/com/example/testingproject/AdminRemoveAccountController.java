package com.example.testingproject;

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
import static com.example.testingproject.Online_Bank.find_Client_Acc;

public class AdminRemoveAccountController implements Initializable {

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


    String username1;

    void setUsername (String username) {

       username1 = username;
    }


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

        for (Client client : clients) {

            for (int i =1 ;i<=3; i++) {



                    if (client.checkAccountExists(i)) {

                            if(username1!= null && username1.equals(client.username))
                            AccountSelection.getItems().add(Online_Bank.getClient(client.getId()).getAccounts(i).get_id());

                    }

                    else break;


            }
        }

        }



    @FXML
    void removebtnClicked (ActionEvent event) {



        int accountno = Integer.parseInt(AccountSelection.getValue());



        Online_Bank.Admin.BanClientAcc(username1,accountno);


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
