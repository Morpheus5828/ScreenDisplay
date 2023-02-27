package com.screendisplay.v2.Model;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JSONManagement {
    private File[] PLListRepo;
    private File[] PLRepo;
    private JSONExtraction je;

    public JSONManagement() {}
    public void load() throws IOException {
        try {
            PLListRepo = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists").listFiles();
            for(int index = 0; index < PLListRepo.length; index++) {
                System.out.println(PLListRepo[index]);
                PLRepo = PLListRepo[index].listFiles();
                // EXTRACT JSON
                assert PLRepo != null;
                for (File file : PLRepo) {
                    this.je = new JSONExtraction(file);
                    this.je.loadFXML();
                    //Controller.buttonsPlaylist.add(new Button(this.je.getPlayListName()));
                }
            }
            //this.vb.writeCode();
        } catch (NullPointerException e) {
            System.err.println("FAILED - Path problem when reading JSON");
        }
    }

    public void removeFXMLs() throws IOException {
        PLListRepo = new File("C:\\Users\\thorr\\IdeaProjects\\ScreenDisplay\\src\\main\\resources\\com\\screendisplay\\playLists").listFiles();
        for(File file : PLListRepo) {
            if(!file.getName().equals("JSON")) FileUtils.deleteDirectory(file);
        }

    }



}
