package com.screendisplay.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public void create() {
        try {
            createRepo(playListName);
            createRepo("FXML");
            this.file = new File(this.path + "\\slide" + number + ".fxml");
            FileWriter myWriter = new FileWriter(file);
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

}
