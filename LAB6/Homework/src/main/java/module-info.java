module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.lab6 to javafx.fxml;
    exports com.example.lab6;
}