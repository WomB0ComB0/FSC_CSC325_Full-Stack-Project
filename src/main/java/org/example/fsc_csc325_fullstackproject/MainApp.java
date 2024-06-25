package org.example.fsc_csc325_fullstackproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//fsc_csc325_fullstackproject
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/fsc_csc325_fullstackproject/view/PersonView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/org/example/fsc_csc325_fullstackproject/view/styles.css").toExternalForm());
        stage.setTitle("FSC CSC325 _ Full Stack Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}