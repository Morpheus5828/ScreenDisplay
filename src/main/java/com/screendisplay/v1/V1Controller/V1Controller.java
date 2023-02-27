package com.screendisplay.v1.V1Controller;

import com.screendisplay.v1.SlideNb;
import com.screendisplay.v2.Controller.Slide.Slide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class V1Controller {
    private SlideNb currentSlide = SlideNb.SLIDE0;
    @FXML private StackPane v1Stackpane;
    @FXML private Button left_btn;
    @FXML private Button right_btn;


    public void changeToSeeRightSlide(ActionEvent actionEvent) throws IOException {
        setCurrentSlide(currentSlide.nextSlide(currentSlide));
        String path = currentSlide.getPath();
        System.out.println(path);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(path).toURI().toURL());
        Parent root = fxmlLoader.load();
        v1Stackpane.getChildren().setAll(root);
        v1Stackpane.getChildren().removeAll();
        v1Stackpane.getChildren().setAll(root);
        System.out.println(currentSlide);
    }

    public void changeToSeeLeftSlide(ActionEvent actionEvent) throws IOException {
        setCurrentSlide(currentSlide.beforeSlide(currentSlide));
        String path = currentSlide.getPath();
        System.out.println(path);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(new File(path).toURI().toURL());
        Parent root = fxmlLoader.load();
        v1Stackpane.getChildren().setAll(root);
        v1Stackpane.getChildren().removeAll();
        v1Stackpane.getChildren().setAll(root);
        System.out.println(currentSlide);
    }

    public void setCurrentSlide(SlideNb currentSlide) {
        this.currentSlide = currentSlide;
    }
}
