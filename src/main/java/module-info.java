module org.example.fsc_csc325_fullstackproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires transitive javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.example.fsc_csc325_fullstackproject to javafx.fxml;
    exports org.example.fsc_csc325_fullstackproject;
}