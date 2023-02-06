package com.screendisplay.Model;

import java.io.IOException;

public class JSONManagment {
    private JSONExtraction jsonExtraction;
    private JSONWriter jsonWritter;
    private String jsonFile;

    public JSONManagment(String playListName) throws IOException {
        this.jsonWritter = new JSONWriter(playListName);
        this.jsonFile = jsonWritter.getJsonPath();
        this.jsonExtraction = new JSONExtraction(jsonWritter.getJsonFile());

        // Extract slide fxml now
        this.jsonWritter.createFXML();

    }

    public String getFirstSlidePath() {
        return this.jsonWritter.getJsonMap().get("Slide0");
    }

}
