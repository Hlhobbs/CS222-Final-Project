package edu.bsu.cs222;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChoosePictureFromUrl {


    public Image getpicture()
    {
        BufferedImage image = null;
        try
        {
            File pathToFile = new File("D:\\google.jpg");
            image = ImageIO.read(pathToFile);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }
}
