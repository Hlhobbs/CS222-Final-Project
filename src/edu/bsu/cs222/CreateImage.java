package edu.bsu.cs222;

import javafx.scene.image.Image;

import java.io.InputStream;

//CreateImage takes the InputStream from the file picker and creates an image out of it.

public class CreateImage {

    Image image;

    public CreateImage(InputStream InputPath) {
        image = new Image(InputPath);
    }

    public CreateImage(String StringPath) {
        image = new Image(StringPath);
    }

    public Image returnImage() {
        return image;
    }
}
