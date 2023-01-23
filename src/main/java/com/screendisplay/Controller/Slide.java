package com.screendisplay.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Slide {
    private String url;

    public Slide(int slideNumber) throws IOException {
        File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\slide" + slideNumber + ".fxml");
        Files.write(file.toPath(), initEmptySlide().getBytes());
        this.url = "playLists\\slide" + slideNumber + ".fxml";

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    private String initEmptySlide() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<?import javafx.scene.layout.BorderPane?>\n" +
                "<?import javafx.scene.layout.Pane?>\n" +
                "<?import javafx.scene.shape.Line?>\n" +
                "\n" +
                "\n" +
                "<BorderPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"575.0\" prefWidth=\"857.0\" xmlns=\"http://javafx.com/javafx/19\" fx:controller=\"com.screendisplay.Controller.SlideController\" xmlns:fx=\"http://javafx.com/fxml/1\">\n" +
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

}
