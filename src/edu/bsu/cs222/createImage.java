package edu.bsu.cs222;

import javafx.scene.image.Image;

public class createImage {

    Image image;

    public createImage(String InputPath) {
        image = new Image(InputPath);
    }

    public Image returnImage() {
        return image;
    }
}
