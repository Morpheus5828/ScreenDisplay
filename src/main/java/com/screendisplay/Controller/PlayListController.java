package com.screendisplay.Controller;

import com.screendisplay.Controller.Slide.SlideController;
import com.screendisplay.HelloApplication;
import com.screendisplay.Model.JSONManagement;
import com.screendisplay.Model.JSONWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import org.xml.sax.XMLReader;

import javax.security.auth.login.Configuration;
import java.net.MalformedURLException;
import java.util.*;


public class PlayListController {
    @FXML private Button createPlaylist;
    @FXML private Pane playlistPane;
    @FXML private StackPane stackPane;
    @FXML private BorderPane borderPane;
    private Stage playlistConfigStage;
    public Set<Button> buttonList = new HashSet<>();


    public PlayListController() {}



    public void addPlaylist(ActionEvent actionEvent) throws IOException {
        openPlayListConfiguration();
    }

    private void openPlayListConfiguration() {
        Pane pane = new Pane();

        TextField playlistName = new TextField();
        playlistName.setPromptText("NAME");
        playlistName.setLayoutX(76);
        playlistName.setLayoutY(25);
        playlistName.setPrefHeight(25);
        playlistName.setPrefWidth(150);

        Button ok = new Button("CREER");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(!hasCharacter(playlistName.getText())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erreur");
                        alert.setContentText("La nouvelle playlist n'a pas de nom attribué");
                        alert.show();
                    } else {
                        new JSONWriter(playlistName.getText());
                        VboxButtonPlayListController.list.add(createButtonPlaylist(playlistName.getText()));
                        VboxButtonPlayListController.writeCode();
                        playlistConfigStage.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        ok.setLayoutX(105);
        ok.setLayoutY(228);

        pane.getChildren().add(playlistName);
        pane.getChildren().add(ok);
        pane.setPrefWidth(282.0);
        pane.setPrefHeight(322.0);
        playlistConfigStage = new Stage();
        Scene scene = new Scene(pane,320, 240);
        playlistConfigStage.setTitle("Playlist configuration");
        playlistConfigStage.setScene(scene);
        playlistConfigStage.setMinHeight(200);
        playlistConfigStage.setMinWidth(200);
        playlistConfigStage.show();
    }

    public Button createButtonPlaylist(String repo) throws IOException {
        Button button = new Button(repo);
        addEvent(button, "src/main/resources/com/screendisplay/playLists/" + repo + "/slide0.fxml");
        buttonList.add(button);
        return button;
    }

    private void addEvent(Button button, String file) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println(file);
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(new File(file).toURI().toURL());
                        Parent root = fxmlLoader.load();
                        stackPane.getChildren().setAll(root);
                        stackPane.getChildren().removeAll();
                        stackPane.getChildren().setAll(root);
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    /* Tool method */
    private boolean hasCharacter(String word) {
        if(word.length() == 0) return false;
        for(char s : word.toCharArray()) {
            if(s != ' ') return true;
        }
        return false;
    }


}