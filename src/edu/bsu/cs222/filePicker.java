package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class filePicker extends Application {

    InputStream inputStream = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("File Picker");

        FileChooser testFileChooser = new FileChooser();
        testFileChooser.setTitle("File Chooser");
        testFileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        File chosenTestFile = testFileChooser.showOpenDialog(null);

        if (chosenTestFile != null) {
            inputStream = new FileInputStream(chosenTestFile);
        } else {
            System.out.println("Null inputStream");
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
