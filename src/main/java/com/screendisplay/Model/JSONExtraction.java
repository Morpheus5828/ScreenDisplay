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
        initMap();
    }

    public void extract() throws IOException {
        try {
            Reader reader = new FileReader(this.jsonFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while((line = bufferedReader.readLine()) != null) this.jsonString += line;
            this.jsonObject = new JSONObject(this.jsonString);
        } catch (Exception e) {
            System.out.println("FAILED - JSON Extraction");
        }
    }

    public void initMap() {
        try {
            for(String key : this.jsonObject.keySet()) this.jsonMap.put(key, getValue(key));
        } catch (Exception e) {
            System.out.println("FAILED - JSON Map Initialisation");
        }
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

    public void loadFXML() {
       try {
           int nb = 0;
           for(int index = 1; index < this.jsonMap.size(); index++) {
               new FXMLWriter(this.getPlayListName(), nb, this.jsonMap.get("slide" + nb)).create();
               nb++;
           }
       } catch (Exception e) {
           System.out.println("FAILED - LoadFxml ");
       }
    }

    public String getPlayListName() { return this.jsonMap.get("playListName");}

}
