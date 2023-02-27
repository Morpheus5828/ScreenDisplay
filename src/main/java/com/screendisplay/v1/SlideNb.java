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
    }
}
