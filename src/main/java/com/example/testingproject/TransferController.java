package com.example.testingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.jar.Attributes;

public class TransferController {

    @FXML
    private TextField Accountnotxt;
    @FXML
    private Button Backbtn;
    @FXML
    private Button Logoutbtn;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private TextField amounttxt;

    @FXML
    private Label approvelabel;

    @FXML
    private Label failedlabel;

    @FXML
    private TextField nameofusertxt;

    @FXML
    private Button transferbtn;

    int amount;
    public String name;

    int receiverId ;
    public String receiverName;


    private int id;

    private int account_no;

    void setId (int id,int account_no) {

        this.id = id;
        this.account_no = account_no;

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
    @FXML
    void Backbtnclicked(ActionEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            HomeController homeController = loader.getController();
            homeController.setId(id,account_no);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void Transeferbtnclicked(ActionEvent event) {
        amount = Integer.parseInt(amounttxt.getText());
        receiverId = Integer.parseInt(Accountnotxt.getText());
        receiverName = nameofusertxt.getText();

        Client c_receiver = Online_Bank.find_Receiver(receiverName);
            if (c_receiver != null && c_receiver.checkAccountExists(receiverId)) {
                if (Online_Bank.getClient(id).getAccounts(account_no).get_balance() >= amount) {

                    Online_Bank.getClient(id).getAccounts(account_no).set_balance(-1 * amount);
                    c_receiver.getAccounts(receiverId).set_balance(amount);

                    approvelabel.setText("Transfer completed and your new balance is equal to " + Online_Bank.getClient(id).getAccounts(account_no).get_balance());
                    failedlabel.setText("");
                } else {

                    failedlabel.setText("Transfer failed due to insufficient balance");
                    approvelabel.setText("");

                }
            } else if (c_receiver == null) {
                failedlabel.setText("User Not Found");
                approvelabel.setText("");
            } else {
                failedlabel.setText("Account Not Found");
                approvelabel.setText("");
            }


        }
    }

