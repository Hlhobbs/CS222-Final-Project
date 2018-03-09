package edu.bsu.cs222;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ChoosePictureFromUrl {


    public BufferedImage getpicture()
    {
        BufferedImage image = null;
        try {
            URL imageUrl = new URL("https://upload.wikimedia.org/wikipedia/en/a/a9/Example.jpg");
            InputStream in = imageUrl.openStream();
            image = ImageIO.read(in);
            in.close();
        }
        catch (IOException ioe) {
            //log the error
        }
        return image;
    }
}
