package edu.bsu.cs222;


import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Test;


public class Tests {

    @Test
    public void testChoosePictureFromFile() {
        ChooseUrl pictureFromFile = new ChooseUrl();
        Image readPicture = pictureFromFile.getPictureFromUrl("https://en.wikipedia.org/wiki/Main_Page#/media/File:Pyeongchang_Olympic_Stadium_at_day_for_2018_Winter_Paralympics_opening_ceremony_-_5.jpg");
        Assert.assertNotNull(readPicture);
    }

    @Test
    public void testChoosePictureFromUrl() {
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
