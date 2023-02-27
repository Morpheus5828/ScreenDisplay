package com.screendisplay;

import com.screendisplay.v2.Controller.Controller;
import com.screendisplay.v2.Model.JSONManagement;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    private JSONManagement jsonManagement;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("administrateur.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("ScreenDisplay");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(800);


        loadButton();
        loadPlayListFXML();
        // delete all fxml file after closing app
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    jsonManagement.removeFXMLs();
                } catch (IOException e) {
                    System.out.println("FAILED - Remove FXML file");
                }
            }
        });

        stage.show();
    }

    public void loadPlayListFXML() throws IOException {
        jsonManagement = new JSONManagement();
        jsonManagement.load();
    }

    public void loadButton() throws IOException {
        // create algo FXML with button inside
        File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\_buttonPlaylist.txt");
        String line;
        List<Button> buttonList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while((line = br.readLine()) != null) {
            Button button = new Button(line);
            Controller.buttonsPlaylist.add(button);
            buttonList.add(button);
        }
        //FXMLWriter fxmlWriter = new FXMLWriter();
        //fxmlWriter.writeCode(buttonList);
    }

    public static void main(String[] args) {
        launch();
    }
}