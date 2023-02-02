package com.screendisplay;

import com.screendisplay.Model.JSONExtraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class TestJSONExtraction {
    private File json = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists\\JSONTest");
    private JSONExtraction jsonExtraction = new JSONExtraction(json);


    @Test
    public void testExtract() throws IOException {
        String jsonContent = "{    \"playListName\":\"VieScolaire\",    \"slide0\":{}}";
        jsonExtraction.extract();
        Assertions.assertEquals(jsonExtraction.getJsonString(), jsonContent);
    }

    @Test
    public void testGetKey() throws IOException {
        jsonExtraction.extract();
        Assertions.assertEquals(jsonExtraction.getKey().toString(), "[playListName, slide0]");
    }

    @Test
    public void testInitMap() throws IOException {
        jsonExtraction.extract();
        jsonExtraction.initMap();
        Assertions.assertEquals(jsonExtraction.getJsonMap().toString(), "{playListName=VieScolaire, slide0=}");
    }

}
