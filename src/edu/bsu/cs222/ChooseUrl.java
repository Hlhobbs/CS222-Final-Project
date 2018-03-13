package edu.bsu.cs222;

import javafx.scene.image.Image;

public class ChooseUrl {

    public Image getPictureFromUrl(String url) {
        Image image;
        CreateImage newImage = new CreateImage(url);
        image = newImage.returnImage();

        return image;
    }
}
