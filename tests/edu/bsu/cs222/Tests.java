package edu.bsu.cs222;


import org.junit.jupiter.api.Test;


import javafx.scene.image.Image;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class Tests {

    @Test
    public void testChoosePictureFromFile()
    {
        ChoosePicture pictureFromFile = new ChoosePicture();
        Image readPicture = pictureFromFile.getPictureFromFile();
        assertNotNull(readPicture);
    }

    @Test
    public void testChoosePictureFromUrl()
    {
        ChoosePicture pictureFromUrl = new ChoosePicture();
        Image readPicture = pictureFromUrl.getPictureFromUrl();
        assertNotNull(readPicture);
    }

    @Test
    public void testPixel() {
        Pixel pixel = new Pixel();
        pixel.setAlphaValue(12);
        assertEquals(12, pixel.getAlphaValue());
    }

    @Test
    public void testScanPictureForColors() {
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        ChoosePicture choosePictureFromUrl = new ChoosePicture();
        List<Pixel> listofpixels = new ArrayList<>();
        Image image = choosePictureFromUrl.getPictureFromUrl();
        listofpixels = scanPictureForColors.ScanPixelsforColors(image);
        assertNotNull(listofpixels);

    }

    @Test
    public void testScanPictureForColorsGreen() {
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        ChoosePicture choosePictureFromUrl = new ChoosePicture();
        List<Pixel> listofpixels = new ArrayList<>();
        Image image = choosePictureFromUrl.getPictureFromUrl();
        listofpixels = scanPictureForColors.ScanPixelsforColors(image);
        assertNotNull(listofpixels.get(1).getGreenValue());

    }

}
