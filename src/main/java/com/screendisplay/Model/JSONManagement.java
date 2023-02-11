package com.screendisplay.Model;

import com.screendisplay.Controller.PlayListController;
import com.screendisplay.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.apache.commons.io.FileUtils;

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
                this.je = new JSONExtraction(file);
                this.je.loadFXML();
                // add button playlist to playListController

            }
        }
    }

    public void removeFXMLs() throws IOException {
        PLListRepo = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists").listFiles();
        for(File file : PLListRepo) {
            if(!file.getName().equals("JSON")) FileUtils.deleteDirectory(file);
        }

    }



}
