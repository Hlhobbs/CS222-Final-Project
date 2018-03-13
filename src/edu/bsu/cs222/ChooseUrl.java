package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;

public class ChooseUrl {

    public  Image getPictureFromUrl()
    {
        Image image = null;
        try {
            URL imageUrl = new URL("https://upload.wikimedia.org/wikipedia/en/a/a9/Example.jpg");
            InputStream input = imageUrl.openStream();
            CreateImage newimage = new CreateImage(input);
            image = newimage.returnImage();
            input.close();
        }
        catch (IOException ioe) {
            //log the error
        }
        return image;
    }
}
