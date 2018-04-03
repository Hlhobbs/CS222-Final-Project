package edu.bsu.cs222;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;


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
    public void testPixel_2() {
        Pixel pixel = new Pixel();
        pixel.setBlueValue(150);
        pixel.setGreenValue(150);
        pixel.setRedValue(150);
        pixel.setHexValue();
        Assert.assertEquals("#969696", pixel.getHexValue());
    }

    @Test
    public void testPixel_3() {
        Pixel pixel = new Pixel();
        pixel.setCount(156);
        Assert.assertEquals(156, pixel.getCount());
    }

    @Test
    public void testReturnStringHexValue() {
        Pixel pixel = new Pixel();
        ReturnStringHexValue hex = new ReturnStringHexValue(pixel);
        pixel.setBlueValue(255);
        pixel.setRedValue(255);
        pixel.setGreenValue(255);
        String result = hex.returnStringHexValue();

        Assert.assertEquals("#ffffff", result);
    }

    @Test
    //Tests DeleteRepeatColors with an array of identical Pixels
    public void testSimplifyColors_1() {
        Pixel pixel1 = new Pixel();
        pixel1.setBlueValue(150);
        pixel1.setGreenValue(150);
        pixel1.setRedValue(150);
        pixel1.setHexValue();

        Pixel pixel2 = new Pixel();
        pixel2.setBlueValue(150);
        pixel2.setGreenValue(150);
        pixel2.setRedValue(150);
        pixel2.setHexValue();

        LinkedList<Pixel> LL = new LinkedList<>();
        LL.add(pixel1);
        LL.add(pixel2);

        Assert.assertEquals(2, LL.size());

        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(LL);
        LL = sc.returnShrunkList();
        Assert.assertEquals(1, LL.size());
    }

    @Test
    //Tests DeleteRepeatColors with an array of different Pixels
    public void testSimplifyColors_2() {
        Pixel pixel1 = new Pixel();
        pixel1.setBlueValue(150);
        pixel1.setGreenValue(150);
        pixel1.setRedValue(150);
        pixel1.setHexValue();

        Pixel pixel2 = new Pixel();
        pixel2.setBlueValue(50);
        pixel2.setGreenValue(50);
        pixel2.setRedValue(50);
        pixel2.setHexValue();

        LinkedList<Pixel> LL = new LinkedList<>();
        LL.add(pixel1);
        LL.add(pixel2);

        Assert.assertEquals(2, LL.size());

        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(LL);
        LL = sc.returnShrunkList();
        Assert.assertEquals(2, LL.size());
    }

    @Test
    //Tests Deleting underused Colors
    public void testSimplifyColors_3() {
        Pixel pixel1 = new Pixel();
        pixel1.setBlueValue(150);
        pixel1.setGreenValue(150);
        pixel1.setRedValue(150);
        pixel1.setHexValue();

        Pixel pixel2 = new Pixel();
        pixel2.setBlueValue(50);
        pixel2.setGreenValue(50);
        pixel2.setRedValue(50);
        pixel2.setHexValue();

        LinkedList<Pixel> LL = new LinkedList<>();
        LL.add(pixel1);
        LL.add(pixel2);
        LL.add(pixel2);
        LL.add(pixel2);

        Assert.assertEquals(4,LL.size());

        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(LL);
        sc.DeleteRareColors(1);
        LL = sc.returnShrunkList();

        Assert.assertEquals(2,LL.size());
    }

    @Test
    //Tests with a valid string
    public void testMinimumUsesFromTextField_1() throws Exception {
        MinimumUsesFromTextField minimumUsesFromTextField = new MinimumUsesFromTextField("16");
        int uses = minimumUsesFromTextField.asInt();
        Assert.assertEquals(16, uses);
    }

    @Test
    //Tests with a invalid string
    public void testMinimumUsesFromTextField_2() throws Exception {
        MinimumUsesFromTextField minimumUsesFromTextField = new MinimumUsesFromTextField("ZZ");
        int uses = minimumUsesFromTextField.asInt();
        Assert.assertEquals(0, uses);
    }

}
