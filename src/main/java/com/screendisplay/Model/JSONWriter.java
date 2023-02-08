package com.screendisplay.Model;

import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JSONWriter {
    private File jsonFile;
    private Map<String, String> jsonMap;

    /* PlayList already exist */
    public JSONWriter(File file) throws IOException {
        if(file != null) {
            this.jsonFile = file;
            this.jsonMap = new JSONExtraction(this.jsonFile).getJsonMap();
        }
    }
    /* Create a new playlist */
    public JSONWriter(String playListName) {
        this.jsonFile = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\" + playListName);
        this.jsonMap = new HashMap<>();
    }

    public void addNewSlide() {
        this.jsonMap.put("Slide" + getSlideNb(),getEmptySlide());
    }

    public void removeSlide(int number) {
        this.jsonMap.remove("Slide" + number);
    }

    private int getSlideNb() {
        return this.jsonMap.size() + 1;
    }

    public File getJsonFile() {
        return jsonFile;
    }

    public Map<String, String> getJsonMap() {
        return this.jsonMap;
    }

    private String getEmptySlide() {
        return "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "\n" +
                "<?import javafx.scene.control.Button?>\n" +
                "<?import javafx.scene.layout.BorderPane?>\n" +
                "<?import javafx.scene.layout.Pane?>\n" +
                "\n" +
                "<BorderPane fx:id='borderPane' maxHeight='-Infinity' maxWidth='-Infinity' minHeight='-Infinity' minWidth='-Infinity' prefHeight='264.0' prefWidth='394.0' xmlns='http://javafx.com/javafx/19' xmlns:fx='http://javafx.com/fxml/1' fx:controller='com.screendisplay.Controller.Slide.SlideController'>\n" +
                "   <center>\n" +
                "      <Pane fx:id='pane' prefHeight='259.0' prefWidth='290.0' BorderPane.alignment='CENTER'>\n" +
                "         <children>\n" +
                "            <Pane fx:id='slideDisplay' layoutX='14.0' layoutY='26.0' prefHeight='210.0' prefWidth='255.0' style='-fx-border-color: grey; -fx-background-color: beige;' />\n" +
                "         </children>\n" +
                "      </Pane>\n" +
                "   </center>\n" +
                "   <left>\n" +
                "      <Pane prefHeight='201.0' prefWidth='110.0' style='-fx-background-color: grey;' BorderPane.alignment='CENTER'>\n" +
                "   </left>\n" +
                "</BorderPane>\n";
    }

    public String getJsonPath() {
        return this.jsonFile.getPath();
    }

    public String getValue(String key) {
        return this.jsonMap.get(key);
    }

    public String getPlayListName() {
        return getValue("playListName");
    }
}
