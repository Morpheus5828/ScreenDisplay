package com.screendisplay.Model;

import org.json.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JSONExtraction {
    private File jsonFile;
    private String jsonString = "";
    private Map<String, String> jsonMap;
    private JSONObject jsonObject;

    public JSONExtraction(File file) throws IOException {
        this.jsonFile = file;
        this.jsonMap = new HashMap<>();
        extract();
    }

    public void extract() throws IOException {
        Reader reader = new FileReader(this.jsonFile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while((line = bufferedReader.readLine()) != null) this.jsonString += line;
        this.jsonObject = new JSONObject(this.jsonString);
        initMap();
    }

    private void initMap() {
        for(String key : this.jsonObject.keySet()) this.jsonMap.put(key, getValue(key));
    }

    public String getValue(String key) {
        return this.jsonObject.get(key).toString();
    }

    public Set<String> getKey() {
        return this.jsonObject.keySet();
    }

    public Map<String, String> getJsonMap() {
        return this.jsonMap;
    }

    public String getJsonString() {
        return jsonString;
    }

    public String getPlayListName() { return this.jsonMap.get("playListName");}

}
