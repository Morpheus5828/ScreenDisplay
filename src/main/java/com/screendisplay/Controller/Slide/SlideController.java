package com.screendisplay.Controller.Slide;

import com.screendisplay.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SlideController {
    @FXML private BorderPane borderPane;
    @FXML private Pane pane;
    @FXML private Pane slideDisplay;
    private List<Text> texts;
    private int slideDisplayNumber;


    public SlideController() throws IOException {
        this.slideDisplayNumber = 0;
        this.texts = new ArrayList<>();
       // createFirstSlide();
       // displaySlides(this.slides.get(0)); // display first slide
    }

    public void displaySlides(File file) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file.getAbsolutePath()));
        Parent fxml = fxmlLoader.load();
        borderPane.getChildren().removeAll();
        borderPane.getChildren().setAll(fxml);
    }

    public void createFirstSlide() throws IOException {
        File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\slide" + slideDisplayNumber +".fxml");
        Files.write(file.toPath(), initEmptySlide().getBytes());
        this.slideDisplayNumber++;
    }

    public void addSlide() throws IOException {
        File file = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\slide" + slideDisplayNumber +".fxml");
        Files.write(file.toPath(), initEmptySlide().getBytes());
        this.slideDisplayNumber++;
    }

    private String initEmptySlide() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<?import javafx.scene.layout.BorderPane?>\n" +
                "<?import javafx.scene.layout.Pane?>\n" +
                "<?import javafx.scene.shape.Line?>\n" +
                "\n" +
                "\n" +
                "<BorderPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"575.0\" prefWidth=\"857.0\" xmlns=\"http://javafx.com/javafx/19\" fx:controller=\"com.screendisplay.Controller.Slide.SlideController\" xmlns:fx=\"http://javafx.com/fxml/1\">\n" +
                "   <top>\n" +
                "      <Pane prefHeight=\"99.0\" prefWidth=\"600.0\" style=\"-fx-background-color: blue;\" BorderPane.alignment=\"CENTER\" />\n" +
                "   </top>\n" +
                "   <center>\n" +
                "      <Pane prefHeight=\"443.0\" prefWidth=\"708.0\" BorderPane.alignment=\"CENTER\">\n" +
                "         <children>\n" +
                "            <Pane layoutX=\"29.0\" layoutY=\"21.0\" prefHeight=\"421.0\" prefWidth=\"635.0\" style=\"-fx-border-color: grey; -fx-background-color: beige;\">\n" +
                "               <children>\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"54.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"146.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"238.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"336.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"438.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"30.0\" endY=\"407.0\" layoutX=\"524.0\" layoutY=\"14.0\" startX=\"30.0\" startY=\"-14.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"101.0\" layoutY=\"81.0\" startX=\"-100.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"100.0\" layoutY=\"165.0\" startX=\"-100.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"101.0\" layoutY=\"250.0\" startX=\"-100.0\" />\n" +
                "                  <Line endX=\"534.0\" layoutX=\"101.0\" layoutY=\"343.0\" startX=\"-100.0\" />\n" +
                "               </children>\n" +
                "            </Pane>\n" +
                "         </children>\n" +
                "      </Pane>\n" +
                "   </center>\n" +
                "   <left>\n" +
                "      <Pane prefHeight=\"476.0\" prefWidth=\"164.0\" style=\"-fx-background-color: grey;\" BorderPane.alignment=\"CENTER\" />\n" +
                "   </left>\n" +
                "</BorderPane>\n"



                ;
    }

    public void addTextButton(MouseEvent mouseEvent) throws IOException {
        TextField text = new TextField("Appuyer pour modifier");
        text.setLayoutX(slideDisplay.getLayoutX()/2);
        text.setLayoutY(slideDisplay.getLayoutY()/2);
        text.setStyle("-fx-border-color: black");
        text.setStyle("-fx-background-color: white");
        text.setPrefWidth(140);
        slideDisplay.getChildren().add(text);

        text.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 1 || mouseEvent.getClickCount() == 2){
                        text.setEditable(true);
                        text.setStyle("-fx-background-color: white");
                    }
                }
                text.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode() == KeyCode.ENTER) {
                            text.setEditable(false);
                            text.setStyle("-fx-background-color: beige");
                        }



                    }
                });
            }
        });




    }
}
