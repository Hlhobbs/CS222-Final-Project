package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class imageTests extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Test");
        Image testImage = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/USS_Lexington_%28CV-2%29_leaving_San_Diego_on_14_October_1941_%2880-G-416362%29.jpg/640px-USS_Lexington_%28CV-2%29_leaving_San_Diego_on_14_October_1941_%2880-G-416362%29.jpg");
        ImageView testImageView = new ImageView(testImage);

        StackPane pane = new StackPane();
        pane.getChildren().add(testImageView);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
