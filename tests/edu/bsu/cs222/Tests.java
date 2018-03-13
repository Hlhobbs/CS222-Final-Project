package edu.bsu.cs222;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;


import javafx.scene.image.Image;
import org.junit.Test;



public class Tests {

    @Test
    public void testChoosePictureFromFile()
    {
        ChoosePicture pictureFromFile = new ChoosePicture();
        Image readPicture = pictureFromFile.getPictureFromUrl();
        Assert.assertNotNull(readPicture);
    }

    @Test
    public void testChoosePictureFromUrl()
    {
        ChoosePicture pictureFromUrl = new ChoosePicture();
        Image readPicture = pictureFromUrl.getPictureFromUrl();
        Assert.assertNotNull(readPicture);
    }

    @Test
    public void testPixel() {
        Pixel pixel = new Pixel();
        pixel.setAlphaValue(12);
        Assert.assertEquals(12, pixel.getAlphaValue(), 0);
    }

    @Test
    public void testScanPictureForColors() {
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        ChoosePicture choosePictureFromUrl = new ChoosePicture();

        ObservableList<Pixel> listofpixels = FXCollections.observableArrayList();

        Image image = choosePictureFromUrl.getPictureFromUrl();
        listofpixels = scanPictureForColors.ScanPixelsforColors(image);
        Assert.assertNotNull(listofpixels);

    }

    @Test
    public void testScanPictureForColorsGreen() {
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors();
        ChoosePicture choosePictureFromUrl = new ChoosePicture();

        ObservableList<Pixel> listofpixels = FXCollections.observableArrayList();
        Image image = choosePictureFromUrl.getPictureFromUrl();

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
