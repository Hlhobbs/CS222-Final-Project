package edu.bsu.cs222;

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



}
