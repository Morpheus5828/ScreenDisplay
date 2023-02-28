package com.screendisplay.v1;

public enum SlideNb {
    SLIDE0, SLIDE1, SLIDE2;

    public SlideNb nextSlide(SlideNb slideNb) {
        switch (slideNb) {
            case SLIDE0 -> {
                return SLIDE1;
            }

            case SLIDE1 -> {
                return SLIDE2;
            }

            case SLIDE2 -> {
                return SLIDE0;
            }
        }
        return slideNb;
    }

    public SlideNb beforeSlide(SlideNb slideNb) {
        switch (slideNb) {
            case SLIDE0 -> {
                return SLIDE2;
            }

            case SLIDE1 -> {
                return SLIDE0;
            }

            case SLIDE2 -> {
                return SLIDE1;
            }
        }
        return slideNb;
    }

    public String getPath() {
        switch (this) {
            case SLIDE0 -> {
                return "C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version 1.0\\slide0.fxml";
            }
            case SLIDE1 -> {
                return "C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version 1.0\\slide1.fxml";
            }
            case SLIDE2 -> {
                return "C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\version 1.0\\slide2.fxml";
            }
        }
        return null;
    }

}
