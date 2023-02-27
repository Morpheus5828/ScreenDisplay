package com.screendisplay.v2.Controller.Slide;

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
    }

}
