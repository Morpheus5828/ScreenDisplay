package com.screendisplay;

import com.screendisplay.Model.JSONExtraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;



public class TestJSONExtraction {

    @Test
    public void testExtract() {
        File json = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\JSONTest.json");
        JSONExtraction jsonExtraction = new JSONExtraction(json);
        Assertions.assertEquals("d", "c");
    }

}
