package com.screendisplay.v1.V1Controller;

import com.screendisplay.v1.SlideNb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;

public class V1Controller {
    @FXML private StackPane v1Stackpane;
    @FXML private Button left_btn;
    @FXML private Button right_btn;
    private Slide slide0 = new Slide("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version 1.0\\picture\\bvn-vie-sco.png");
    private Slide slide1 = new Slide("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version 1.0\\picture\\acutalite-vie-sco.png");
    private Slide slide2 = new Slide("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version 1.0\\picture\\prof_abs.png");
    private SlideNb currentSlideNB = SlideNb.SLIDE0;
    private Slide currentSlide = slide0;

    public void changeToSeeRightSlide(ActionEvent actionEvent) throws IOException {
        setCurrentSlideNB(currentSlideNB.nextSlide(currentSlideNB));
        currentSlide = getNextSlide(currentSlide);
        v1Stackpane.getChildren().removeAll();
        v1Stackpane.getChildren().add(getScene(currentSlideNB).getMainPane());
        System.out.println(currentSlideNB);
    }

    public void changeToSeeLeftSlide(ActionEvent actionEvent) throws IOException {
        setCurrentSlideNB(currentSlideNB.beforeSlide(currentSlideNB));
        currentSlide = getBeforeSlide(currentSlide);
        v1Stackpane.getChildren().removeAll();
        v1Stackpane.getChildren().add(getScene(currentSlideNB).getMainPane());
        System.out.println(currentSlideNB);

    }

    public void setCurrentSlideNB(SlideNb currentSlideNB) {
        this.currentSlideNB = currentSlideNB;
    }

    public void addTextToSlide() {
        TextField textField = new TextField();
        textField.prefWidth(40);
        textField.setPromptText("Clicker pour modifier");

        currentSlide.getMainPane().getChildren().add(textField);

        class Delta { double x, y; }
        final Delta dragDelta = new Delta();
        textField.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = textField.getLayoutX() - mouseEvent.getSceneX();
                dragDelta.y = textField.getLayoutY() - mouseEvent.getSceneY();
                textField.setCursor(Cursor.MOVE);
            }
        });
        textField.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                textField.setCursor(Cursor.HAND);
            }
        });
        textField.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                textField.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                textField.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
            }
        });
    }

    public Slide getNextSlide(Slide slide) {
        if (slide.equals(slide0)) {
            return slide1;
        } else if (slide.equals(slide1)) {
            return slide2;
        } else if (slide.equals(slide2)) {
            return slide0;
        }
        return null;
    }

    public Slide getBeforeSlide(Slide slide) {
        if (slide.equals(slide0)) {
            return slide2;
        } else if (slide.equals(slide1)) {
            return slide0;
        } else if (slide.equals(slide2)) {
            return slide1;
        }
        return null;
    }

    public Slide getScene(SlideNb slideNb) {
        switch (slideNb) {
            case SLIDE0 -> {
                return slide0;
            }
            case SLIDE1 -> {
                return slide1;
            }
            case SLIDE2 -> {
                return slide2;
            }
        }
        return null;
    }

}
