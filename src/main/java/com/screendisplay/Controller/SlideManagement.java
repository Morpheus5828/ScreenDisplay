package com.screendisplay.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SlideManagement {
    private String url = "";
    private List<Slide> slides;

    public SlideManagement() throws IOException {
        this.slides = new ArrayList<>();
        createFirstSlide();
    }

    public String getUrl(int slideNumber) {
        return this.slides.get(slideNumber).getUrl();
    }

    public void createFirstSlide() throws IOException {
        Slide slide = new Slide(0);
        this.slides.add(slide);
    }


}
