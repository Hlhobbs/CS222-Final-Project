package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ScanPictureForColors {


    public List<Pixel> ScanPixelsforColors(BufferedImage image) {

        List<Pixel> listofscannedpixels = new ArrayList<>();

        int w = image.getWidth();
        int h = image.getHeight();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                Pixel datapixel = new Pixel();
                datapixel.setxCoordinate(j);
                datapixel.setyCoordinate(i);

                int picturepixel = image.getRGB(j, i);

                datapixel.setAlphaValue( (picturepixel >> 24) & 0xff);
                datapixel.setRedValue( (picturepixel >> 16) & 0xff );
                datapixel.setGreenValue( (picturepixel >> 8) & 0xff);
                datapixel.setBlueValue( (picturepixel) & 0xff);
                listofscannedpixels.add(datapixel);
                ;

            }
        }
        return listofscannedpixels;
    }

    public List<Pixel> ScanPixelsforColors(Image image) {

        List<Pixel> listofscannedpixels = new ArrayList<>();

        double w = image.getWidth();
        double h = image.getHeight();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                Pixel datapixel = new Pixel();
                datapixel.setxCoordinate(j);
                datapixel.setyCoordinate(i);

                PixelReader pixelReader =image.getPixelReader();
                int picturepixel = pixelReader.getArgb(j,i);

                datapixel.setAlphaValue( (picturepixel >> 24) & 0xff);
                datapixel.setRedValue( (picturepixel >> 16) & 0xff );
                datapixel.setGreenValue( (picturepixel >> 8) & 0xff);
                datapixel.setBlueValue( (picturepixel) & 0xff);
                listofscannedpixels.add(datapixel);
                ;

            }
        }
        return listofscannedpixels;
    }
}
