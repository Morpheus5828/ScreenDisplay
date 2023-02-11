package com.screendisplay.Model;

import com.screendisplay.Controller.PlayListController;
import com.screendisplay.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONManagement {
    private File[] PLListRepo;
    private File[] PLRepo;
    private List<Button> buttonPlayList;
    private PlayListController playListController;
    private JSONExtraction je;

    public JSONManagement(PlayListController playListController) {
        this.buttonPlayList = new ArrayList<>();
        this.playListController = playListController;
    }

    public void load() throws IOException {
        PLListRepo = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists").listFiles();
        // search all FXML file,  PLAYLISTS
        for(int index = 0; index < PLListRepo.length; index++) {
            PLRepo = PLListRepo[index].listFiles();
            // EXTRACT JSON
            assert PLRepo != null;
            for(File file : PLRepo) {
                // check if file isn't FXML repository
                if(!file.getName().equals("FXML")) {
                    this.je = new JSONExtraction(file);
                    this.je.loadFXML();
                }
            }
        }
    }

    /*private void addEvent(Button button, String string) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file.getAbsolutePath()));
                    Parent fxml = fxmlLoader.load();
                    playListController.getVboxButtonPlayList().getChildren().clear();
                    playListController.getVboxButtonPlayList().getChildren().removeAll();
                    playListController.getVboxButtonPlayList().getChildren().setAll(fxml);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }*/

}
