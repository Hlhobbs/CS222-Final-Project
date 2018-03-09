package edu.bsu.cs222;

import javafx.scene.image.Image;

import java.io.InputStream;

public class createImage {

    Image image;

    public createImage(InputStream InputPath) {
        image = new Image(InputPath);
    }

    public createImage(String StringPath) {
        image = new Image(StringPath);
    }

    public Image returnImage() {
        return image;
    }
}
