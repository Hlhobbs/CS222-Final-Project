package edu.bsu.cs222;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
public class ChoosePicture {

    public Image getPictureFromFile()
    {
        Image image = null;
        try
        {
            java.io.FileInputStream pathToFile = new FileInputStream("D:\\google.jpg");
            image = new Image(pathToFile);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }

    public  Image getPictureFromUrl()
    {
        Image image = null;
        try {
            URL imageUrl = new URL("https://upload.wikimedia.org/wikipedia/en/a/a9/Example.jpg");
            InputStream in = imageUrl.openStream();
            createImage newimage = new createImage(in);
            image = newimage.returnImage();
            in.close();
        }
        catch (IOException ioe) {
            //log the error
        }
        return image;
    }
}
