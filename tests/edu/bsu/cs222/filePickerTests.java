package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class filePickerTests extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("filePickerTests");

        FileChooser testFileChooser = new FileChooser();
        testFileChooser.setTitle("Test File Chooser");
        testFileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        File chosenTestFile = testFileChooser.showOpenDialog(null);

        if (chosenTestFile != null) {
            InputStream inputStream = new FileInputStream(chosenTestFile);
            createImage image = new createImage(inputStream);
            Image createdImage = image.returnImage();
            javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(createdImage);

            StackPane Pane = new StackPane();
            Pane.getChildren().add(imageView);

            Scene scene = new Scene(Pane);
            primaryStage.setScene(scene);
            primaryStage.show();

        }

    }

}
