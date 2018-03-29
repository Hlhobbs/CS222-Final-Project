package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class pictureView extends Application {


    //Turn into controller + FXML
    //pictureView makes a new stage to display a picture for the GUI

    private ImageView view = null;

    @Override
    public void start(Stage primaryStage) {
        StackPane Pane = new StackPane();
        Pane.getChildren().add(view);

        Scene scene = new Scene(Pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void view(ImageView imageView) { this.view = imageView; }
}
