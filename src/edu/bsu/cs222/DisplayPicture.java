package edu.bsu.cs222;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DisplayPicture {

    private ImageView view;

    public DisplayPicture(ImageView imageView) {
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);
        this.view = imageView;
    }

    public void picture() {
        pictureView pictureView = new pictureView();
        pictureView.view(view);
        Stage stage = new Stage();
        pictureView.start(stage);
    }
}
