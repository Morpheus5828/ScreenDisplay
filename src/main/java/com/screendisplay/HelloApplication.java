package com.screendisplay;

import com.screendisplay.Controller.PlayListController;
import com.screendisplay.Model.FXMLWriter;
import com.screendisplay.Model.JSONManagement;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("administrateur.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        loadPlayListFXML();
        //stage.show();
    }

    public void loadPlayListFXML() throws IOException {
        new JSONManagement(new PlayListController()).load();
    }

    public static void main(String[] args) {
        launch();
    }
}