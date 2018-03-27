package edu.bsu.cs222;

import javafx.scene.image.Image;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ChooseUrl {

    public Image getPictureFromUrl(String inputURL) {
        /*Image image;
        CreateImage newImage = new CreateImage(url);
        image = newImage.returnImage();

        return image;
        */
        /*BufferedImage image = null;
        try {
            URL url = new URL(inputURL);
            image = ImageIO.read(url);
        } catch (IOException e) {
        }
        return image;
        */

        boolean backgroundLoading = true;
        Image image = new Image(inputURL, backgroundLoading);
        return image;

    }
}
