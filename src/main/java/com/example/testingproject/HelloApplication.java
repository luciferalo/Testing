package com.example.testingproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

   Online_Bank START=new Online_Bank(true);

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
           // FXMLLoader/ fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
           // Scene scene = new Scene(fxmlLoader.load());
           // stage.setTitle("Login Page");
            //stage.setScene(scene);
            //stage.show();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}