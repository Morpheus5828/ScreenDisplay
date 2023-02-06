package com.screendisplay.Model;

import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JSONWriter {
    private File jsonFile;
    private Map<String, String> jsonMap;
    private String playlistName;

    /* PlayList already exist */
    public JSONWriter(File file) {
        //TODO check if file already exist
        this.jsonFile = file;
        this.jsonMap = new HashMap<>();
    }
    /* Create a new playlist */
    public JSONWriter(String playListName) {
        this.jsonFile = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\" + playListName);
        JSONExtraction jsonExtraction = new JSONExtraction(this.jsonFile);
        this.jsonMap = jsonExtraction.getJsonMap();
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
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<?import javafx.scene.layout.BorderPane?>\n" +
                "<?import javafx.scene.layout.Pane?>\n" +
                "<?import javafx.scene.shape.Line?>\n" +
                "\n" +
                "\n" +
                "<BorderPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"575.0\" prefWidth=\"857.0\" xmlns=\"http://javafx.com/javafx/19\" fx:controller=\"com.screendisplay.Controller.Slide.SlideController\" xmlns:fx=\"http://javafx.com/fxml/1\">\n" +
                "   <top>\n" +
                "      <Pane prefHeight=\"99.0\" prefWidth=\"600.0\" style=\"-fx-background-color: blue;\" BorderPane.alignment=\"CENTER\" />\n" +
                "   </top>\n" +
                "   <center>\n" +
                "      <Pane prefHeight=\"443.0\" prefWidth=\"708.0\" BorderPane.alignment=\"CENTER\">\n" +
                "         <children>\n" +
                "            <Pane layoutX=\"29.0\" layoutY=\"21.0\" prefHeight=\"421.0\" prefWidth=\"635.0\" style=\"-fx-border-color: grey; -fx-background-color: beige;\">\n" +
                "               <children>\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"54.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"146.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"238.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"336.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"438.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"524.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"101.0\" layoutY=\"81.0\" startX=\"-100.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"100.0\" layoutY=\"165.0\" startX=\"-100.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"101.0\" layoutY=\"250.0\" startX=\"-100.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"101.0\" layoutY=\"343.0\" startX=\"-100.0\" />\n" +
                "               </children>\n" +
                "            </Pane>\n" +
                "         </children>\n" +
                "      </Pane>\n" +
                "   </center>\n" +
                "   <left>\n" +
                "      <Pane prefHeight=\"476.0\" prefWidth=\"164.0\" style=\"-fx-background-color: grey;\" BorderPane.alignment=\"CENTER\" />\n" +
                "   </left>\n" +
                "</BorderPane>\n"



                ;
    }

    public String getJsonPath() {
        return this.jsonFile.getPath();
    }

    public String getValue(String key) {
        return this.jsonMap.get(key);
    }

    public void createFXML() {
        for(String key : this.jsonMap.keySet()) {
            try {
                File file = new File(getValue(key) + ".fxml");
                FileWriter myWriter = new FileWriter(file);
                myWriter.write(getValue(key)); // all data from JSON Slide
                myWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
