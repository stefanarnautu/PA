module com.example.compulsory {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.compulsory to javafx.fxml;
    exports com.example.compulsory;
}