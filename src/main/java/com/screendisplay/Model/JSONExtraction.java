package com.screendisplay.Model;

import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONExtraction {
    private File file;
    private Map<String, String> jsonContent;

    public JSONExtraction(File file) {
        this.file = file;
    }

    public String extract() {
        JSONObject jsonObject = new JSONObject(file);
        return jsonObject.getString("playListName");

    }

    public Map<String, String> getJsonContent() {
        return jsonContent;
    }
}
