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
import java.util.List;

public class scanTests extends Application {

    public void start(Stage primaryStage) throws Exception {

        FileChooser testFileChooser = new FileChooser();
        testFileChooser.setTitle("Test File Chooser");
        testFileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        File chosenTestFile = testFileChooser.showOpenDialog(null);

        InputStream inputStream = new FileInputStream(chosenTestFile);
        CreateImage image = new CreateImage(inputStream);
        Image createdImage = image.returnImage();
        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(createdImage);

        StackPane Pane = new StackPane();
        Pane.getChildren().add(imageView);

        Scene scene = new Scene(Pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        List<Pixel> list = scanPictureForColors.ScanPixelsForColors(createdImage);
        List<Image>  imageList;

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
