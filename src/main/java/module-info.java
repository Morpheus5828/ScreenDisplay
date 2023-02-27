module com.screendisplay {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.apache.commons.io;
    requires java.xml;

    opens com.screendisplay to javafx.fxml;
    exports com.screendisplay;
    exports com.screendisplay.v2.Controller;
    opens com.screendisplay.v2.Controller to javafx.fxml;
    opens com.screendisplay.v2.Controller.Slide to javafx.fxml;
    exports com.screendisplay.v2.Controller.Slide;

}