package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowSelectedPicture extends Application{

    private ImageView imageView;

    public ShowSelectedPicture(ImageView iv) {
        this.imageView = iv;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane Pane = new StackPane();
        Pane.getChildren().add(imageView);

        Scene scene = new Scene(Pane);
        primaryStage.setTitle("Image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
