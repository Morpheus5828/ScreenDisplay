package com.screendisplay.Model;

import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFXMLUpdate {
    private String repository;
    private String slide;
    private final String version = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private final String importation =
            "<?import javafx.scene.control.Button?>\n" +
            "<?import javafx.scene.layout.BorderPane?>\n" +
            "<?import javafx.scene.layout.Pane?>\n" +
            "<?import javafx.scene.layout.TextField?>\n";
    private String borderPane = "<BorderPane fx:id=\"slideBorderPane\" maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"264.0\" prefWidth=\"394.0\" xmlns=\"http://javafx.com/javafx/19\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"com.screendisplay.Controller.Controller\">\n";
    private String toolPane =
            "<center>\n" +
            "   <Pane fx:id=\"pane\" prefHeight=\"259.0\" prefWidth=\"290.0\" BorderPane.alignment=\"CENTER\">\n" +
            "       <children>\n" +
            "            <Pane fx:id=\"slideDisplay\" layoutX=\"14.0\" layoutY=\"26.0\" prefHeight=\"210.0\" prefWidth=\"255.0\" style=\"-fx-border-color: grey; -fx-background-color: beige;\" />\n" +
            "       </children>\n" +
            "   </Pane>\n" +
            "</center>";
    private StringBuilder body;

    public SaveFXMLUpdate(String repository, String slide) {
        this.repository = repository;
        this.slide = slide;
        this.body = new StringBuilder();
    }

    public void addTextField(TextField textField) {
            this.body.append("<TextField prefWidth=\"100\" promptText=\"Entrer text\" layoutX=\"" + textField.getLayoutX() + "\" layoutY=\" " + textField.getLayoutY() + "\"></TextField>");
    }

    public void saveModification() throws IOException {
        File fxml = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\" + this.repository + "\\" + this.slide);
        FileWriter fileWriter = new FileWriter(fxml);
        fileWriter.write(
                this.version + "\n" +
                    this.importation + "\n" +
                    this.borderPane + "\n" +
                    this.toolPane + "\n" +
                    "<left>\n" +
                    "<Pane prefHeight=\"201.0\" prefWidth=\"110.0\" style=\"-fx-background-color: grey;\" BorderPane.alignment=\"CENTER\">\n" +
                    "<children>" +
                    this.body.toString() +
                    "</children></Pane>" +
                    "</left>" +
                    "</BorderPane>"
        );
        fileWriter.close();
    }

}

