package edu.bsu.cs222;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
public class ChoosePictureFromFile {

    public Image getpicture()
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
}
