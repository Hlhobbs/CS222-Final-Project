package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class imageTests extends Application {

    @Override
    //Enter a 1,2, or 3 into the terminal to test manually, from a url, or from a file path respectively
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Test");
        Image testManually = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/USS_Lexington_%28CV-2%29_leaving_San_Diego_on_14_October_1941_%2880-G-416362%29.jpg/640px-USS_Lexington_%28CV-2%29_leaving_San_Diego_on_14_October_1941_%2880-G-416362%29.jpg");
        ImageView manualImageView = new ImageView(testManually);

        CreateImage urlCreateImage = new CreateImage("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/USS_Lexington_%28CV-2%29_leaving_San_Diego_on_14_October_1941_%2880-G-416362%29.jpg/640px-USS_Lexington_%28CV-2%29_leaving_San_Diego_on_14_October_1941_%2880-G-416362%29.jpg");
        Image testWithURL = urlCreateImage.returnImage();
        ImageView urlImageView = new ImageView(testWithURL);

        Image testWithFile = testWithURL;
        ImageView fileImageView = new ImageView(testWithFile);

        StackPane manualPane = new StackPane();
        manualPane.getChildren().add(manualImageView);

        StackPane urlPane = new StackPane();
        urlPane.getChildren().add(urlImageView);

        StackPane filePane = new StackPane();
        filePane.getChildren().add(fileImageView);

        Scene manualScene = new Scene(manualPane);
        Scene urlScene = new Scene(urlPane);
        Scene fileScene = new Scene(filePane);

        Scanner scanner = new Scanner(System.in);
        byte chosenScene = scanner.nextByte();

        Scene scannedScene = null;

        if (chosenScene == 1) {
            scannedScene = manualScene;
        } else if (chosenScene == 2) {
            scannedScene = urlScene;
        } else if (chosenScene == 3) {
            scannedScene = fileScene;
        }

        primaryStage.setScene(scannedScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
