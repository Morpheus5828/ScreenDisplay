module com.screendisplay {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.screendisplay to javafx.fxml;
    exports com.screendisplay;
    exports com.screendisplay.Controller;
    opens com.screendisplay.Controller to javafx.fxml;

}