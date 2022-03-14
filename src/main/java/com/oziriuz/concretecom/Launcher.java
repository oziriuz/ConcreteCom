package com.oziriuz.concretecom;

import com.oziriuz.concretecom.controller.LauncherPreloaderController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Launcher extends Application {

    public static Stage primaryStage = null;
    //public static Scene primaryScene = null;

    @Override
    public void init() {
        LauncherPreloaderController init = new LauncherPreloaderController();
        init.checkSuccessfulStart();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Launcher.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("login-view.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add("dark-theme.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        System.setProperty("javafx.preloader", LauncherPreloader.class.getCanonicalName());
        launch(args);
    }
}
