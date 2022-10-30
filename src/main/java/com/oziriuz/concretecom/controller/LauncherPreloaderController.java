package com.oziriuz.concretecom.controller;

import com.oziriuz.concretecom.model.orm.DatabaseManager;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LauncherPreloaderController implements Initializable {

    public Label lblLoading;
    public static Label lblLoadingg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblLoadingg = lblLoading;
    }

    public void checkSuccessfulStart() {
        final String[] message = new String[5];
        message[0] = "Verification ... Ensuring Database";
        message[1] = "Second function";
        int threadCounter;
        //TODO: this all must be in the model or not??
        //TODO: initialize OPC connection

        Thread t1 = new Thread(() -> {
            Platform.runLater(() -> lblLoadingg.setText(message[0]));
            try {
                DatabaseManager.ensureDatabase();
                Thread.sleep(333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            Platform.runLater(() -> lblLoadingg.setText(message[1]));
            try {
                Thread.sleep(333);
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
    }
}
