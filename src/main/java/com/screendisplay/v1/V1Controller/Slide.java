package com.screendisplay.v1.V1Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Slide {
    private List<TextFieldComponent> mainPaneChildren;
    private String imageUrl;
    private String name;

    public static class TextFieldComponent {
        private String name;
        private double layoutX;
        private double layoutY;

        public TextFieldComponent(String name, double layoutX, double layoutY) {
            this.name = name;
            this.layoutX = layoutX;
            this.layoutY = layoutY;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLayoutX(double layoutX) {
            this.layoutX = layoutX;
        }

        public void setLayoutY(double layoutY) {
            this.layoutY = layoutY;
        }

        public String getName() {
            return name;
        }

        public double getLayoutX() {
            return layoutX;
        }

        public double getLayoutY() {
            return layoutY;
        }
    }

    public Slide() {}

    public Slide(String imageURL, String name) throws IOException {
        this.name = name;
        this.imageUrl = imageURL;
        this.mainPaneChildren = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void addChildren(String name, double layoutX, double layoutY) {
        this.mainPaneChildren.add(new TextFieldComponent(name, layoutX, layoutY));
    }

    public List<TextFieldComponent> getMainPaneChildren() {
        return mainPaneChildren;
    }

    @Override
    public String toString() {
        String result = "";
        for(TextFieldComponent t : mainPaneChildren) {
            result += t.name + "," + t.layoutX + "," + t.layoutY + ";";
        }
        return result + " ";
    }
}
