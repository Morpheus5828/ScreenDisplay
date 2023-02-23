package com.screendisplay.Controller;

import com.screendisplay.HelloApplication;
import com.screendisplay.Model.FXMLWriter;
import com.screendisplay.Model.JSONWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable{
    public static List<Button> buttonsPlaylist = new ArrayList<>();
    /* Main page properties */
    @FXML private Button screen;
    @FXML private Button playlist;
    @FXML private Button document;
    @FXML private Button user;
    @FXML private StackPane contentArea;
    /* PlayList properties */
    @FXML private BorderPane playlistConfigBp;
    @FXML private Pane playlistPane;
    @FXML private Button createPlaylist;
    @FXML private StackPane playListListSp;
    @FXML private VBox playlistConfigVbox;
    private Stage playlistConfigStage;

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlistConfig.fxml"));
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

    /* Playlist methods */
    public void addButtonPlayLists() {
        this.playlistConfigBp.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        for(Button button : buttonsPlaylist)
            playlistConfigVbox.getChildren().add(button);
    }

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
                        List<Button> list = new ArrayList<>();
                        Button button = createButtonPlaylist(playlistName.getText());
                        list.add(button);
                        playlistConfigVbox.getChildren().add(button);
                        File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\_buttonPlaylist.txt");
                        new FileWriter(file).write(list.toString());
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
                        playListListSp.getChildren().setAll(root);
                        playListListSp.getChildren().removeAll();
                        playListListSp.getChildren().setAll(root);
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Tool method
    private boolean hasCharacter(String word) {
        if(word.length() == 0) return false;
        for(char s : word.toCharArray()) {
            if(s != ' ') return true;
        }
        return false;
    }


}