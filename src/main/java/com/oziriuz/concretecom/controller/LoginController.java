package com.oziriuz.concretecom.controller;

import com.oziriuz.concretecom.Launcher;
import com.oziriuz.concretecom.model.LoginValidation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    public Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnClick() {

        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {

            if (LoginValidation.isValidLogin(usernameTextField.getText(), passwordPasswordField.getText())) {
                try {
                    loadMainWindow();
                    //TODO: check if it is ok to close the stage by using the cancel method!
                    cancelButtonOnClick();
                } catch (IOException e) {
                    //TODO: proper exception handling
                    e.printStackTrace();
                }
            } else {
                loginMessageLabel.setText("Invalid login. Please try again.");
            }
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }

    public void cancelButtonOnClick() {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loadMainWindow() throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("ConcreteCom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}