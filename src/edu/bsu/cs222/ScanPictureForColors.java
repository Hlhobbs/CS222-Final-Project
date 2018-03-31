package edu.bsu.cs222;


import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

import java.util.LinkedList;

public class ScanPictureForColors {

/* ScanPixelsForColors takes an image and outputs an observable list of Pixels. The method scans the image and gets the RGB values
of each pixel in the image and populates the list with pixels each with RBG values.
 */

    private LinkedList<Pixel> ScannedPixels;

    public ScanPictureForColors(Image image) {

        ScannedPixels = new LinkedList<>();

        double w = image.getWidth();
        double h = image.getHeight();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                Pixel datapixel = new Pixel();
                datapixel.setX_Coordinate(j);
                datapixel.setY_Coordinate(i);

                PixelReader pixelReader = image.getPixelReader();
                int picturePixel = pixelReader.getArgb(j, i);

                datapixel.setAlphaValue((picturePixel >> 24) & 0xff);
                datapixel.setRedValue((picturePixel >> 16) & 0xff);
                datapixel.setGreenValue((picturePixel >> 8) & 0xff);
                datapixel.setBlueValue((picturePixel) & 0xff);
                datapixel.setHexValue();

                ScannedPixels.add(datapixel);

            }
        }
    }

    public LinkedList<Pixel> returnPixel() {
        return this.ScannedPixels;
    }

}
