package com.screendisplay;

import com.screendisplay.Controller.Controller;
import com.screendisplay.Model.JSONManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private JSONManagement jsonManagement;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("administrateur.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(800);


        //loadPlayListFXML();

        // delete all fxml file after closing app
//        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                try {
//                    jsonManagement.removeFXMLs();
//                } catch (IOException e) {
//                    System.out.println("FAILED - Remove FXML file");
//                }
//            }
//        });

        stage.show();
    }

    public void loadPlayListFXML() throws IOException {
        jsonManagement = new JSONManagement();
        jsonManagement.load();
        //TODO creer une page fxml après lextraction du json et ensuite l'ouvrir dans playlist controller
    }

    public static void main(String[] args) {
        launch();
    }
}