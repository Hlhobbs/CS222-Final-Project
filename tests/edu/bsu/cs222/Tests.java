package edu.bsu.cs222;


import org.junit.Assert;
import org.junit.Test;


public class Tests {

    //When using the exampleImage, the LinkedList HexValues should contain the following values [#000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d]
    //When using the exampleImage, the LinkedList, ShrinkedHexValues should contain the following values [#000000, #ffffff, #ff0000, #24ff00, #f0ff00, #ff5b8d]


    @Test
    public void testPixel() {
        Pixel pixel = new Pixel();
        pixel.setAlphaValue(12);
        Assert.assertEquals(12, pixel.getAlphaValue(), 0);
    }


    @Test
    public void testReturnStringHexValue() {
        Pixel pixel = new Pixel();
        ReturnStringHexValue hex = new ReturnStringHexValue();
        pixel.setBlueValue(255);
        pixel.setRedValue(255);
        pixel.setGreenValue(255);
        String result = hex.returnStringHexValue(pixel);

        Assert.assertEquals("#ffffff", result);
    }

}
