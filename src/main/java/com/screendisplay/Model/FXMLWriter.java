package com.screendisplay.Model;

import javafx.scene.control.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FXMLWriter {
    private String contain;
    private int number;
    private String playListName;
    private File file;
    private String path;

    public FXMLWriter(String playListName, int number, String contain) throws IOException {
        this.contain = contain;
        this.number = number;
        this.playListName = playListName;
        this.path = "C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists";
    }

    public FXMLWriter() {}

    public void createVboxButtonPlaylist() {
        File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\buttonPlaylist.txt");

    }

    public void create() {
        try {
            createRepo(playListName);
            this.file = new File(this.path + "\\slide" + number + ".fxml");
            this.file = new File(this.path + "\\slide0.fxml");
            FileWriter myWriter = new FileWriter(file);
            //System.out.println(contain);
            myWriter.write(contain); // all data from JSON Slide
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createRepo(String string) throws IOException {
        System.out.println(this.path + "\\" + string);
        File repo = new File(this.path + "\\" + string);
        repo.mkdir();
        this.path += "\\" + string;
    }

    private String produceFXMLCode(List<Button> list) {
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


    public void writeCode(List<Button> list) throws IOException {
        try {
            File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\buttonPlaylist.txt");
            FileWriter myWritter = new FileWriter(file);
            myWritter.write(produceFXMLCode(list));
            myWritter.close();

        } catch (Exception e) {
            System.out.println("FAILED - buttonPlaylist.txt");
        }

    }


}
