package com.screendisplay;

import com.screendisplay.Model.JSONExtraction;
import com.screendisplay.Model.JSONWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class TestJSONWriter {
    private JSONWriter jsonWriter = new JSONWriter("TeacherRoom");

    public TestJSONWriter() throws IOException {
    }

    @Test
    public void testAddNewSlide() throws IOException {
        Assertions.assertEquals(jsonWriter.getJsonMap().keySet().size(), 0);
        jsonWriter.addNewSlide();
        Assertions.assertEquals(jsonWriter.getJsonMap().keySet().size(), 1);
    }

    @Test
    public void testRemoveSlide() throws IOException {
        jsonWriter.addNewSlide();
        jsonWriter.addNewSlide();
        Assertions.assertEquals(jsonWriter.getJsonMap().keySet().size(), 2);
        jsonWriter.removeSlide(1);
        Assertions.assertEquals(jsonWriter.getJsonMap().keySet().size(), 1);
    }

}
