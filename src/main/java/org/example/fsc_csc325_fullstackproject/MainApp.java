package org.example.fsc_csc325_fullstackproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

//fsc_csc325_fullstackproject
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(
                MainApp.class.getResource("/org/example/fsc_csc325_fullstackproject/view/PersonView.fxml"));
        Scene scene = new Scene(root.load());
        scene.getStylesheets()
                .add(Objects
                        .requireNonNull(
                                getClass().getResource("/org/example/fsc_csc325_fullstackproject/view/styles.css"))
                        .toExternalForm());
        stage.setTitle("FSC CSC325 _ Full Stack Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}