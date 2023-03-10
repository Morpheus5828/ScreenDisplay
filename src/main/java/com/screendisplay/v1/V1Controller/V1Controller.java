package com.screendisplay.v1.V1Controller;

import com.screendisplay.ScreenDisplayV1;
import com.screendisplay.v1.SlideNb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class V1Controller {
    @FXML public StackPane v1Stackpane;
    @FXML public Pane paneElement;
    @FXML public ImageView slideImageView;
    private SlideNb currentSlideNB = SlideNb.SLIDE0;

    public V1Controller() throws IOException {}

    public void changeToSeeRightSlide(ActionEvent actionEvent) throws IOException {
        setCurrentSlideNB(currentSlideNB.nextSlide(currentSlideNB));
        ScreenDisplayV1.setCurrentSlide(getNextSlide(ScreenDisplayV1.getCurrentSlide()));
        slideImageView.setImage(new Image(ScreenDisplayV1.getCurrentSlide().getImageUrl()));
        paneElement.getChildren().clear();
        for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
            TextField textField = new TextField(tfc.getName());
            textField.setBackground(Background.EMPTY);
            textField.setLayoutX(tfc.getLayoutX());
            textField.setLayoutY(tfc.getLayoutY());
            class Delta { double x, y; }
            final Delta dragDelta = new Delta();
            textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    textField.setBackground(Background.EMPTY);

                    textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if(event.getCode() == KeyCode.DELETE) {
                                paneElement.getChildren().remove(textField);
                                for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
                                    if((tfc.getLayoutX() == textField.getLayoutX()) && (tfc.getLayoutY() == textField.getLayoutY()))
                                        ScreenDisplayV1.getCurrentSlide().getMainPaneChildren().remove(tfc);
                                }
                            }

                        }
                    });
                }
            });
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
                    System.out.println(textField.getLayoutX());
                    for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
                        if((tfc.getName().equals(textField.getText()))) {
                            tfc.setLayoutX(textField.getLayoutX());
                            tfc.setLayoutY(textField.getLayoutY());
                            tfc.setName(textField.getText());
                        }
                    }
                }
            });
            paneElement.getChildren().add(textField);
        }


    }

    public void changeToSeeLeftSlide(ActionEvent actionEvent) throws IOException {
        setCurrentSlideNB(currentSlideNB.nextSlide(currentSlideNB));
        ScreenDisplayV1.setCurrentSlide(getBeforeSlide(ScreenDisplayV1.getCurrentSlide()));
        slideImageView.setImage(new Image(ScreenDisplayV1.getCurrentSlide().getImageUrl()));
        paneElement.getChildren().clear();
        for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
            TextField textField = new TextField(tfc.getName());
            textField.setBackground(Background.EMPTY);
            textField.setLayoutX(tfc.getLayoutX());
            textField.setLayoutY(tfc.getLayoutY());
            class Delta { double x, y; }
            final Delta dragDelta = new Delta();
            textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    textField.setBackground(Background.EMPTY);

                    textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if(event.getCode() == KeyCode.DELETE) {
                                paneElement.getChildren().remove(textField);
                                for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
                                    if((tfc.getLayoutX() == textField.getLayoutX()) && (tfc.getLayoutY() == textField.getLayoutY()))
                                        ScreenDisplayV1.getCurrentSlide().getMainPaneChildren().remove(tfc);
                                }
                            }

                        }
                    });
                }
            });
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
                    System.out.println(textField.getLayoutX());
                    for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
                        if((tfc.getName().equals(textField.getText()))) {
                            tfc.setLayoutX(textField.getLayoutX());
                            tfc.setLayoutY(textField.getLayoutY());
                            tfc.setName(textField.getText());
                        }
                    }
                }
            });
            paneElement.getChildren().add(textField);
        }
    }

    public void setCurrentSlideNB(SlideNb currentSlideNB) {
        this.currentSlideNB = currentSlideNB;
    }

    public void updateTextFieldEdition(MouseEvent actionEvent) {
        paneElement.requestFocus();
    }

    public void addTextToSlide(ActionEvent actionEvent) {
        TextField textField = new TextField();
        textField.prefWidth(140);
        textField.setLayoutX(215);
        textField.setLayoutY(179);
        textField.setPromptText("Clicker pour modifier");
        textField.setBackground(Background.EMPTY);
        textField.textProperty().addListener((observable, oldvalue, newvalue) -> {
            System.out.println(oldvalue);
            for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
                if((tfc.getLayoutX() == textField.getLayoutX()) && (tfc.getLayoutY() == textField.getLayoutY()))
                    tfc.setName(textField.getText());
            }
        });

        class Delta { double x, y; }
        final Delta dragDelta = new Delta();
        textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                textField.setBackground(Background.EMPTY);

                textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCode() == KeyCode.DELETE) {
                            paneElement.getChildren().remove(textField);
                            for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
                                if((tfc.getLayoutX() == textField.getLayoutX()) && (tfc.getLayoutY() == textField.getLayoutY()))
                                    ScreenDisplayV1.getCurrentSlide().getMainPaneChildren().remove(tfc);
                            }
                        }

                    }
                });
            }
        });
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
                System.out.println(textField.getLayoutX());
                for(Slide.TextFieldComponent tfc : ScreenDisplayV1.getCurrentSlide().getMainPaneChildren()) {
                    if((tfc.getName().equals(textField.getText()))) {
                        tfc.setLayoutX(textField.getLayoutX());
                        tfc.setLayoutY(textField.getLayoutY());
                        tfc.setName(textField.getText());
                    }
                }
            }
        });
        ScreenDisplayV1.getCurrentSlide().getMainPaneChildren().add(new Slide.TextFieldComponent(textField.getText(), textField.getLayoutX(), textField.getLayoutY()));
        paneElement.getChildren().add(textField);
    }

    public Slide getNextSlide(Slide slide) {
        if (slide.getName().equals(ScreenDisplayV1.getSlide0().getName())) {
            return ScreenDisplayV1.getSlide1();
        } else if (slide.getName().equals(ScreenDisplayV1.getSlide1().getName())) {
            return ScreenDisplayV1.getSlide2();
        } else if (slide.getName().equals(ScreenDisplayV1.getSlide2().getName())) {
            return ScreenDisplayV1.getSlide0();
        }
        return null;
    }

    public Slide getBeforeSlide(Slide slide) {
        if (slide.getName().equals(ScreenDisplayV1.getSlide0().getName())) {
            return ScreenDisplayV1.getSlide2();
        } else if (slide.getName().equals(ScreenDisplayV1.getSlide1().getName())) {
            return ScreenDisplayV1.getSlide0();
        } else if (slide.getName().equals(ScreenDisplayV1.getSlide2().getName())) {
            return ScreenDisplayV1.getSlide1();
        }
        return null;
    }

    public Slide getScene(SlideNb slideNb) {
        switch (slideNb) {
            case SLIDE0 -> {
                return ScreenDisplayV1.getSlide0();
            }
            case SLIDE1 -> {
                return ScreenDisplayV1.getSlide1();
            }
            case SLIDE2 -> {
                return ScreenDisplayV1.getSlide2();
            }
        }
        return null;
    }

    public void sendToReceiver(ActionEvent actionEvent) {
        try (Socket socket = new Socket("localhost", 1234);) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(",");
            //writer.println();
        } catch (Exception e) {
            System.err.println("ERROR - Connection Failed with Receiver");
        }
    }



}
