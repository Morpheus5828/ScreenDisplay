package com.screendisplay.v1.V1Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Slide {
    private Pane mainPane;
    private List<TextFieldComponent> mainPaneChildren;
    private ImageView imageView;
    private Image image;
    private String imageUrl;

    private class TextFieldComponent {
        private String name;
        private int layoutX;
        private int layoutY;

        public TextFieldComponent(String name, int layoutX, int layoutY) {
            this.name = name;
            this.layoutX = layoutX;
            this.layoutY = layoutY;
        }

        public String getName() {
            return name;
        }

        public int getLayoutX() {
            return layoutX;
        }

        public int getLayoutY() {
            return layoutY;
        }
    }

    public Slide() {}

    public Slide(String imageUrl) throws IOException {
       this.mainPane = new Pane();
       this.imageView = new ImageView();
       this.imageUrl = imageUrl;
       this.image = new Image(getClass().getResource(imageUrl).openStream());
       this.imageView.setFitHeight(227.0);
       this.imageView.setFitWidth(365.0);
       this.imageView.setLayoutY(3.0);
       this.imageView.setPickOnBounds(true);
       this.imageView.setPreserveRatio(true);
       this.imageView.setImage(this.image);

       this.mainPane.getChildren().add(this.imageView);
       this.mainPane.setPrefHeight(500);
       this.mainPane.setPrefWidth(500);

       this.mainPaneChildren = new ArrayList<>();
    }

    public Pane getMainPane() {
        return mainPane;
    }

    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void addChildren(String name, int layoutX, int layoutY) {
        this.mainPaneChildren.add(new TextFieldComponent(name, layoutX, layoutY));
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    private String displayMainPane() {
        return "<Pane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"208.0\" prefWidth=\"365.0\" xmlns=\"http://javafx.com/javafx/19\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"com.screendisplay.v1.V1Controller.V1Controller\">\n";
    }

    private String displayImageView() {
        return "<ImageView fitHeight=\"227.0\" fitWidth=\"365.0\" layoutY=\"3.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\n"
                + displayImage() + "</ImageView>";

    }

    private String displayImage() {
        return "<image>\n" +
                "         <Image url=\"@" + this.imageUrl +"\" />\n" +
                "      </image>";
    }

    private String displayTextField() {
        StringBuilder result = new StringBuilder();
        for(TextFieldComponent textField : this.mainPaneChildren) {
            result.append("<TextField layoutX=\"").append(textField.getLayoutX()).append("\" layoutY=\"").append(textField.getLayoutY()).append("\"  >").append(textField.getName()).append("</TextField>");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<?import javafx.scene.image.Image?>" +
                "<?import javafx.scene.image.ImageView?>" +
                "<?import javafx.scene.layout.Pane?>" +
                "<?import javafx.scene.text.Text?>" +
                "<?import javafx.scene.control.TextField?>" +
                displayMainPane() +
                displayImageView() +
                displayTextField() +
                "</Pane>";
    }
}
