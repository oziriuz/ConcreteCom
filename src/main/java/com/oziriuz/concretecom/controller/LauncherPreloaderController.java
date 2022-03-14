package com.oziriuz.concretecom.controller;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LauncherPreloaderController implements Initializable {

    public Label lblLoading;
    public static Label lblLoadingg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblLoadingg = lblLoading;
    }

    public void checkSuccessfulStart() {

        final String[] message = {""};
        //TODO: this all must be in the model or not??
        //TODO: initialize database connection
        //TODO: check existence of tables
        //TODO: create missing tables
        //TODO: check existence of columns in tables
        //TODO: create missing columns
        //TODO: initialize OPC connection

        Thread t1 = new Thread(() -> {
            message[0] = "First function";
            Platform.runLater(() -> lblLoadingg.setText(message[0]));
            try {
                Thread.sleep(555);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            message[0] = "Second function";
            Platform.runLater(() -> lblLoadingg.setText(message[0]));
            try {
                Thread.sleep(555);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return message[0];
    }
}
