package edu.bsu.cs222;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ShowSelectedPicture {

    private ImageView view;

    public ShowSelectedPicture(ImageView imageView) {
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);
        this.view = imageView;
    }

    public void picture() {
        PictureView PictureView = new PictureView();
        PictureView.view(view);
        Stage stage = new Stage();
        PictureView.start(stage);
    }
}
