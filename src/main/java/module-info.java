module com.example.drafts {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.drafts to javafx.fxml;
    exports com.example.drafts;
}