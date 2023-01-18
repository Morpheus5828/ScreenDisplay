package com.screendisplay.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class PlayListController {
    @FXML private Button createPlaylist;
    @FXML private VBox playLists;
    private Stage playlistConfigStage = new Stage();
    private HashMap<Button, SlideController> playlistButtonRedirection = new HashMap<>();

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
                if(!hasCharacter(playlistName.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setContentText("La nouvelle playlist n'a pas de nom attribué");
                    alert.show();
                } else {
                    Button playlistRedirection = new Button(playlistName.getText());

                    try {
                        playlistButtonRedirection.put(playlistRedirection, new SlideController());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    playLists.getChildren().add(new Button(getTextFieldWithoutSpace(playlistName.getText())));
                    playlistConfigStage.close();
                }
            }
        });

        ok.setLayoutX(105);
        ok.setLayoutY(228);

        pane.getChildren().add(playlistName);
        pane.getChildren().add(ok);
        pane.setPrefWidth(282.0);
        pane.setPrefHeight(322.0);

        Scene scene = new Scene(pane,320, 240);
        playlistConfigStage.setTitle("Playlist configuration");
        playlistConfigStage.setScene(scene);
        playlistConfigStage.setMinHeight(200);
        playlistConfigStage.setMinWidth(200);
        playlistConfigStage.show();
    }

    private boolean hasCharacter(String word) {
        if(word.length() == 0) return false;
        for(char s : word.toCharArray()) {
            if(s != ' ') return true;
        }
        return false;
    }

    private String getTextFieldWithoutSpace(String word) {
        String result = "";
        for(char s : word.toCharArray()) if(s != ' ') result += s;
        return result;
    }




}
