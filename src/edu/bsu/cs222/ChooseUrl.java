package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;

public class ChooseUrl {

    public Image getPictureFromUrl(String s) throws IOException {
        Image image = null;
        CreateImage newimage = new CreateImage(s);
        image = newimage.returnImage();

        return image;
    }
}
