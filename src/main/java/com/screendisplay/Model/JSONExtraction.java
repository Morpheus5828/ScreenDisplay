package com.screendisplay.Model;

import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JSONExtraction {
    private File jsonFile;
    private String jsonString = "";
    private Map<String, String> jsonContent;
    private JSONObject jsonObject;

    public JSONExtraction(File file) {
        this.jsonFile = file;
        this.jsonContent = new HashMap<>();
    }

    public void extract() throws IOException {
        Reader reader = new FileReader(this.jsonFile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while((line = bufferedReader.readLine()) != null) this.jsonString += line;
        this.jsonObject = new JSONObject(this.jsonString);
    }

    public String getPlayListName() {
        return this.jsonObject.getString("VieScolaire");
    }

    public Set<String> getKey() {
        return this.jsonObject.keySet();
    }

    public Map<String, String> getJsonContent() {
        return jsonContent;
    }

    public String getJsonString() {
        return jsonString;
    }
}
