package com.screendisplay;

import com.screendisplay.Controller.VboxButtonPlayListController;
import com.screendisplay.Model.JSONExtraction;
import com.screendisplay.Model.JSONWriter;
import javafx.scene.control.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class TestVboxButtonPlayListController {
    private VboxButtonPlayListController vbc = new VboxButtonPlayListController();;

    @Test
    public void displayButton() {
        vbc.addButton(new Button());
    }
}
