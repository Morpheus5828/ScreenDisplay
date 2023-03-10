package com.screendisplay;

import com.screendisplay.v1.V1Controller.Slide;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenDisplayV1 extends Application {
    static Slide currentSlide;
    static Slide slide0;
    static Slide slide1;
    static Slide slide2;

    @Override
    public void start(Stage stage) throws Exception {
        slide0 = new Slide("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version1.0\\picture\\bvn-vie-sco.png", "slide0");
        slide1 = new Slide("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version1.0\\picture\\prof_abs.png", "slide1");
        slide2 = new Slide("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version1.0\\picture\\acutalite-vie-sco.png", "slide2");
        currentSlide = slide0;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("version1.0/administrateur_sdv1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("ScreenDisplay V1");
        stage.setScene(scene);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setResizable(false);
        stage.show();
    }

    public static Slide getSlide0() {
        return slide0;
    }

    public static Slide getSlide1() {
        return slide1;
    }

    public static Slide getSlide2() {
        return slide2;
    }

    public static Slide getCurrentSlide() {
        return currentSlide;
    }

    public static void setCurrentSlide(Slide currentSlide) {
        ScreenDisplayV1.currentSlide = currentSlide;
    }
}
