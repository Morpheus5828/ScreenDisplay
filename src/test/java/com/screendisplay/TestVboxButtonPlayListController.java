package com.screendisplay;

import com.screendisplay.Controller.VboxButtonPlayListController;
import javafx.scene.control.Button;
import org.junit.jupiter.api.Test;

public class TestVboxButtonPlayListController {
    private VboxButtonPlayListController vbc = new VboxButtonPlayListController();;

    @Test
    public void displayButton() {
        vbc.addButton(new Button());
    }
}
