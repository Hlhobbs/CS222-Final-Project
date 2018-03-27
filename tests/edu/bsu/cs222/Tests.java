package edu.bsu.cs222;


import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Test;


public class Tests {

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
