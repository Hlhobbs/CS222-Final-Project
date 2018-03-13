package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;

public class ChoosePicture {

    public  Image getPictureFromUrl()
    {
        Image image = null;
        try {
            URL imageUrl = new URL("https://upload.wikimedia.org/wikipedia/en/a/a9/Example.jpg");
            InputStream in = imageUrl.openStream();
            CreateImage newimage = new CreateImage(in);
            image = newimage.returnImage();
            in.close();
        }
        catch (IOException ioe) {
            //log the error
        }
        return image;
    }
}
