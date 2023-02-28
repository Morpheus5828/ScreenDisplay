package com.screendisplay.v1.V1Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Slide {
    private Pane mainPane;
    private ImageView imageView;
    private Image image;

    public Slide() {}

    public Slide(String url) {
       this.mainPane = new Pane();
       this.imageView = new ImageView();
       this.image = new Image(url);

       this.imageView.setFitHeight(227.0);
       this.imageView.setFitWidth(365.0);
       this.imageView.setLayoutY(3.0);
       this.imageView.setPickOnBounds(true);
       this.imageView.setPreserveRatio(true);
       this.imageView.setImage(this.image);

       this.mainPane.getChildren().add(this.imageView);
       this.mainPane.setPrefHeight(500);
       this.mainPane.setPrefWidth(500);
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

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "";
    }
}
