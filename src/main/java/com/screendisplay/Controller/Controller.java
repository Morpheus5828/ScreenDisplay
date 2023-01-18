package com.screendisplay.Controller;

import com.screendisplay.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable{
    @FXML private Button screen;
    @FXML private Button playlist;
    @FXML private Button document;
    @FXML private Button user;
    @FXML private StackPane contentArea;
    // In playlist fxml page
    @FXML private Button createPlaylist;
    @FXML private VBox playLists;
    private Stage playlistConfigStage = new Stage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        // exit is the image view
        exit.setOn MouseClicked(e-> {
            System.exit(0);
        });
         */

        /*try {
            Parent fxml = FXMLLoader.load(getClass().getResource("administrateur.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            //
        }*/

    }

    public void displayScreens(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("screen.fxml"));
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void displayPlaylists(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist.fxml"));
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void displayDocuments(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("document.fxml"));
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void displayUsers(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("users.fxml"));
        Parent fxml = fxmlLoader.load();
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void addPlaylist(ActionEvent actionEvent) throws IOException {
        openPlayListConfiguration();
    }

    public void createNewPlaylist(ActionEvent actionEvent) throws IOException {
        playlistConfigStage.close();
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
                    alert.setContentText("La nouvelle playlist n'as pas de nom attribué");
                    alert.show();
                } else{
                    //on récupère le nom de la playlist
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