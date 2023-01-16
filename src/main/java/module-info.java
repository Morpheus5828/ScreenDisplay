module com.screendisplay {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.screendisplay to javafx.fxml;
    exports com.screendisplay;
}