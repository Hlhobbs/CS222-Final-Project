package edu.bsu.cs222;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;


import javafx.scene.image.Image;
import org.junit.Test;

import java.io.IOException;


public class Tests {

    @Test
    public void testChoosePictureFromFile() throws IOException {
        ChooseUrl pictureFromFile = new ChooseUrl();
        Image readPicture = pictureFromFile.getPictureFromUrl("https://en.wikipedia.org/wiki/Main_Page#/media/File:Pyeongchang_Olympic_Stadium_at_day_for_2018_Winter_Paralympics_opening_ceremony_-_5.jpg");
        Assert.assertNotNull(readPicture);
    }

    @Test
    public void testChoosePictureFromUrl() throws IOException {
        ChooseUrl pictureFromUrl = new ChooseUrl();
        Image readPicture = pictureFromUrl.getPictureFromUrl("https://en.wikipedia.org/wiki/Main_Page#/media/File:Pyeongchang_Olympic_Stadium_at_day_for_2018_Winter_Paralympics_opening_ceremony_-_5.jpg");
        Assert.assertNotNull(readPicture);
    }

    @Test
    public void testPixel() {
        Pixel pixel = new Pixel();
        pixel.setAlphaValue(12);
        Assert.assertEquals(12, pixel.getAlphaValue(), 0);
    }

    @Test
    public void testScanPictureForColors() throws IOException {
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        ChooseUrl choosePictureFromUrl = new ChooseUrl();

        ObservableList<Pixel> listofpixels = FXCollections.observableArrayList();

        Image image = choosePictureFromUrl.getPictureFromUrl("https://en.wikipedia.org/wiki/Main_Page#/media/File:Pyeongchang_Olympic_Stadium_at_day_for_2018_Winter_Paralympics_opening_ceremony_-_5.jpg");
        listofpixels = scanPictureForColors.ScanPixelsforColors(image);
        Assert.assertNotNull(listofpixels);

    }

    @Test
    public void testScanPictureForColorsGreen() throws IOException {
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        ChooseUrl choosePictureFromUrl = new ChooseUrl();

        ObservableList<Pixel> listofpixels = FXCollections.observableArrayList();
        Image image = choosePictureFromUrl.getPictureFromUrl("https://en.wikipedia.org/wiki/Main_Page#/media/File:Pyeongchang_Olympic_Stadium_at_day_for_2018_Winter_Paralympics_opening_ceremony_-_5.jpg");

        listofpixels = scanPictureForColors.ScanPixelsforColors(image);

        Assert.assertNotNull(listofpixels.get(1).getGreenValue());

    }

    @Test
    public void testReturnStringHexValue() {
        Pixel pixel = new Pixel();
        returnStringHexValue hex = new returnStringHexValue();
        pixel.setBlueValue(255);
        pixel.setRedValue(255);
        pixel.setGreenValue(255);
        String result = hex.returnStringHexValue(pixel);

        Assert.assertEquals("#ffffff", result);
    }

}
