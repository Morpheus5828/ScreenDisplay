package com.screendisplay.Model;

import java.io.File;
import java.io.FileWriter;

public class FXMLWriter {
    private String contain;
    private int number;

    public FXMLWriter(int number, String contain) {
        this.contain = contain;
        this.number = number;
    }

    public void create() {
        try {
            File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\slide" + number + ".fxml");
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(contain); // all data from JSON Slide
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
