package edu.bsu.cs222;


import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;


public class Tests {

    //Tests for all of the utility classes within the project

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
    public void testMinimumUsesFromTextField() throws Exception {
        MinimumUsesFromTextField minimumUsesFromTextField = new MinimumUsesFromTextField("16");
        int uses = minimumUsesFromTextField.asInt();
        Assert.assertEquals(16, uses);
    }

    @Test
    public void testComplementaryColorsFromRGB() {
        Pixel pixel = new Pixel();
        pixel.setRedValue(255);
        pixel.setGreenValue(0);
        pixel.setBlueValue(0);
        Pixel compPixel = new ComplementaryColorsFromRGB(pixel).getCompPixel();
        Assert.assertEquals(0,compPixel.getRedValue(),1);
        Assert.assertEquals(255, compPixel.getGreenValue(),1);
        Assert.assertEquals(255, compPixel.getGreenValue(),1);
    }

    @Test
    public void testComplementaryColorsFromRGB_2() {
        Pixel pixel = new Pixel();
        pixel.setRedValue(0);
        pixel.setGreenValue(180);
        pixel.setBlueValue(0);
        Pixel compPixel = new ComplementaryColorsFromRGB(pixel).getCompPixel();
        compPixel.setHexValue();
        Assert.assertEquals("#b40000", compPixel.getHexValue());
    }

    @Test
    public void testRGBtoHSL_1() {
        double r =160;
        double g = 150;
        double b = 120;
        RGBtoHSL rgBtoHSL = new RGBtoHSL(r,g,b);
        double hue = rgBtoHSL.getH();
        Assert.assertEquals(45.0,hue,1);
    }

    @Test
    public void testRGBtoHSL_2() {
        double r =160;
        double g = 150;
        double b = 120;
        RGBtoHSL rgBtoHSL = new RGBtoHSL(r,g,b);
        double lum = rgBtoHSL.getL();
        Assert.assertEquals(0.549,lum,1);
    }

    @Test
    public void testRGBtoHSL_3() {
        double r =160;
        double g = 150;
        double b = 120;
        RGBtoHSL rgBtoHSL = new RGBtoHSL(r,g,b);
        double saturation = rgBtoHSL.getS();
        Assert.assertEquals(0.173,saturation,1);
    }
}
