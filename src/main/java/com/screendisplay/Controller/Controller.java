package com.screendisplay.Controller;

import com.screendisplay.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable{
    @FXML private Button screen;
    @FXML private Button playlist;
    @FXML private Button document;
    @FXML private Button user;
    @FXML private StackPane contentArea;

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



}