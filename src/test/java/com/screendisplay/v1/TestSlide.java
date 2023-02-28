package com.screendisplay.v1;

import com.screendisplay.v1.V1Controller.Slide;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class TestSlide {
    @Test
    public void displayMainPan() throws IOException {
        Slide slide = new Slide("/com/screendisplay/version1.0/picture/acutalite-vie-sco.png");
//        Assertions.assertEquals(slide.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "\n" +
//                "<?import javafx.scene.image.Image?>\n" +
//                "<?import javafx.scene.image.ImageView?>\n" +
//                "<?import javafx.scene.layout.Pane?>\n" +
//                "<?import javafx.scene.text.Text?>\n" +
//                "<?import javafx.scene.text.TextField?\n" +
//                "><Pane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"208.0\" prefWidth=\"365.0\" xmlns=\"http://javafx.com/javafx/19\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"com.screendisplay.v1.V1Controller.V1Controller\">\n" +
//                "<ImageView fitHeight=\"227.0\" fitWidth=\"365.0\" layoutY=\"3.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\n" +
//                "<image>\n" +
//                "         <Image url=\"@null\" />\n" +
//                "      </image></ImageView></Pane>");
    }

    @Test
    public void addTextField() throws IOException {
        Slide slide = new Slide("/com/screendisplay/version1.0/picture/acutalite-vie-sco.png");
        slide.addChildren("test", 122, 11);
        System.out.println(slide);
    }
}
