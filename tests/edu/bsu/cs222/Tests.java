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
        ChoosePictureFromFile pictureFromFile = new ChoosePictureFromFile();
        Image readPicture = pictureFromFile.getpicture();
        assertNotNull(readPicture);
    }

    @Test
    public void testChoosePictureFromUrl()
    {
        ChoosePictureFromUrl pictureFromUrl = new ChoosePictureFromUrl();
        Image readPicture = pictureFromUrl.getpicture();
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
        ChoosePictureFromUrl choosePictureFromUrl = new ChoosePictureFromUrl();
        List<Pixel> listofpixels = new ArrayList<>();
        Image image = choosePictureFromUrl.getpicture();
        listofpixels = scanPictureForColors.ScanPixelsforColors(image);
        assertNotNull(listofpixels);

    }

    @Test
    public void testScanPictureForColorsGreen() {
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        ChoosePictureFromUrl choosePictureFromUrl = new ChoosePictureFromUrl();
        List<Pixel> listofpixels = new ArrayList<>();
        Image image = choosePictureFromUrl.getpicture();
        listofpixels = scanPictureForColors.ScanPixelsforColors(image);
        assertNotNull(listofpixels.get(1).getGreenValue());

    }

}
