package com.screendisplay.Controller;

import com.screendisplay.Controller.Slide.SlideManagement;
import com.screendisplay.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class PlayListController {
    @FXML private Button createPlaylist;
    @FXML private Pane playlistPane;
    @FXML private StackPane stackPane;
    private Stage playlistConfigStage;

    private Map<Button, SlideManagement> playlistButtonRedirection = new HashMap<>();

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
                        Button button = createButtonPlaylist(playlistName.getText());
                        stackPane.getChildren().add(button);

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

    private void addElementToStackPane(Node child) {
        this.stackPane.getChildren().add(child);
    }

    private Button createButtonPlaylist(String name) throws IOException {
        SlideManagement slide = new SlideManagement();
        Button button = new Button(name);
        // add action event to this button
        redirection(button, slide);


        playlistButtonRedirection.put(button,slide);
        return button;

    }

    private void redirection(Button button, SlideManagement slideManagement) throws IOException {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println(slideManagement.getUrl(0));
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("slide.fxml"));
                    Parent fxml = fxmlLoader.load();
                    stackPane.getChildren().clear();
                    stackPane.getChildren().removeAll();
                    stackPane.getChildren().setAll(fxml);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

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

    private void addActionToButton(Button button, SlideManagement file) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //deleteAllChildren();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void deleteAllChildren() {
        stackPane.getChildren().removeAll();
    }

    //TODO add set on action sur les boutons qui renvoie vers les playlists




}