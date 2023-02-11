package com.screendisplay.Controller;

import javafx.scene.control.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VboxButtonPlayListController {
    public static List<Button> list;

    public VboxButtonPlayListController() {
        list = new ArrayList<>();
    }

    public void addButton(Button button) {
        list.add(button);
        System.out.println(button.getText());
    }

    public static String produceFXMLCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Button button : list) stringBuilder.append("<Button text=\"").append(button.getText()).append("\"/>").append("\n");

        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<?import javafx.scene.control.Button?>\n" +
                "<?import javafx.scene.layout.VBox?>\n" +
                "\n" +
                "\n" +
                "<VBox fx:id=\"vboxButtonPlayList\" maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"300.0\" prefWidth=\"500.0\" xmlns=\"http://javafx.com/javafx/19\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"com.screendisplay.Controller.VboxButtonPlayListController\">\n" +
                "   <children>\n" +
                stringBuilder +
                "   </children>\n" +
                "</VBox>\n";
        return result;
    }


    public static void writeCode() throws IOException {
        try {
            File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\vboxButtonPlayList.fxml");
            FileWriter myWritter = new FileWriter(file);
            myWritter.write(produceFXMLCode());
            myWritter.close();

        } catch (Exception e) {
            System.out.println("FAILED - vboxButtonPlayList.fxml");
        }

    }



}
