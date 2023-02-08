package com.screendisplay.Model;

import com.screendisplay.Controller.PlayListController;
import com.screendisplay.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONManagement {
    private File[] playListRepository;
    private List<Button> buttonPlayList;
    private PlayListController playListController;
    private JSONExtraction jsonExtraction;

    public JSONManagement(PlayListController playListController) {
        this.buttonPlayList = new ArrayList<>();
        this.playListController = playListController;
    }

    public void load() throws IOException {
        playListRepository = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists").listFiles();
        if(playListRepository != null) {
            for(File file : playListRepository) {
                this.jsonExtraction = new JSONExtraction(file);
                for(int index = 0; index < this.jsonExtraction.getJsonMap().size(); index++)
                    new FXMLWriter(index, this.jsonExtraction.getJsonMap().get("slide0")).create();

                Button redirection = new Button(this.jsonExtraction.getPlayListName());
                addEvent(redirection, file);
                this.buttonPlayList.add(redirection);
            }
        }
    }

    private void addEvent(Button button, File file) {
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
    }

}
