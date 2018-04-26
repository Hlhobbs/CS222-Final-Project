package edu.bsu.cs222;


import Functions.*;
import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Test;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;


public class Tests {

    //Tests for all of the utility classes within the project

    @Test
    public void testPixel() {
        LinkedList<Pixel> pixels = LoadPixelTestArray();

        Pixel redPixel = pixels.get(20);
        Assert.assertEquals("#ff0000", redPixel.getHexValue());

        Pixel whitePixel = pixels.get(0);
        Assert.assertEquals("#000000", whitePixel.getHexValue());

        Pixel blackPixel = pixels.get(1);
        Assert.assertEquals("#ffffff",blackPixel.getHexValue());
        
    }

    @Test
    public void testReturnStringHexValue() {
        LinkedList<Pixel> pixels = LoadPixelTestArray();
        ReturnStringHexValue hex = new ReturnStringHexValue(pixels.get(0));
        String result = hex.returnStringHexValue();

        Assert.assertEquals("#000000", result);
    }

    @Test
    //Tests that repeats are removed
    public void testSimplifyColors_1() {
        LinkedList<Pixel> pixels = LoadPixelTestArray();
        Assert.assertEquals(100,pixels.size());

        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(pixels);

        LinkedList<Pixel> shrunkArray = sc.returnShrunkList();
        Assert.assertEquals(6,shrunkArray.size());

        Assert.assertEquals("#f0ff00",shrunkArray.get(0).getHexValue());
        Assert.assertEquals(10,shrunkArray.get(0).getCount());

        Assert.assertEquals("#ff5b8d",shrunkArray.get(1).getHexValue());
        Assert.assertEquals(10,shrunkArray.get(1).getCount());

        Assert.assertEquals("#ffffff",shrunkArray.get(2).getHexValue());
        Assert.assertEquals(50,shrunkArray.get(2).getCount());
    }

    @Test
    public void testSimplifyColors_2() {
        LinkedList<Pixel> pixels = LoadPixelTestArray();
        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(pixels);
        sc.DeleteRareColors(15);

        LinkedList<Pixel> shrunkArray = sc.returnShrunkList();
        Assert.assertEquals(1, shrunkArray.size());
        Assert.assertEquals("#ffffff",shrunkArray.getFirst().getHexValue());

    }

    @Test
    public void testSimplifyColors_3() throws Exception {
        MinimumUsesFromTextField minimumUsesFromTextField = new MinimumUsesFromTextField("16");
        int uses = minimumUsesFromTextField.asInt();

        LinkedList<Pixel> pixels = LoadLargePixelTestArray();
        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(pixels);
        sc.DeleteRareColors(uses);
        pixels = sc.returnShrunkList();

        Iterator<Pixel> iterator = pixels.iterator();

        boolean boo = true;

        while( iterator.hasNext()) {
            if (iterator.next().getCount() < uses) {
                boo = false;
            }
        }

        Assert.assertTrue(boo);

    }

    @Test
    public void testRGBtoHSL_hue() {
        double r =160;
        double g = 150;
        double b = 120;
        RGBtoHSL rgBtoHSL = new RGBtoHSL(r,g,b);
        double hue = rgBtoHSL.getH();
        Assert.assertEquals(45.0,hue,1);
    }

    @Test
    public void testRGBtoHSL_lum() {
        double r =160;
        double g = 150;
        double b = 120;
        RGBtoHSL rgBtoHSL = new RGBtoHSL(r,g,b);
        double lum = rgBtoHSL.getL();
        Assert.assertEquals(0.549,lum,1);
    }

    @Test
    public void testRGBtoHSL_saturation() {
        double r =160;
        double g = 150;
        double b = 120;
        RGBtoHSL rgBtoHSL = new RGBtoHSL(r,g,b);
        double saturation = rgBtoHSL.getS();
        Assert.assertEquals(0.173,saturation,1);
    }

    @Test
    public void testHSLtoHex() {
        double[] hsl = new double[3];
        hsl[0] = 45;
        hsl[1] = 0.173;
        hsl[2] = 0.549;

        HSLtoHex hsLtoHex = new HSLtoHex(hsl);
        String hex = hsLtoHex.returnHex();

        boolean boo = hex.equals("#a09678");
        Assert.assertTrue(boo);
    }

    @Test
    public void testCompColors() {
        String hex = "#a09678";
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(hex);
        String comp = calculateRelatedColors.returnCompColor();

        boolean boo = comp.equals("#7882a0");
        Assert.assertTrue(boo);

    }

    @Test
    public void testSplitComp() {
        String hex = "#a09678";
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(hex);
        String[] splitComp = calculateRelatedColors.returnSplitComp();

        String[] hexValues = {"#a09678","#788fa0","#7b78a0"};

        Assert.assertArrayEquals(hexValues, splitComp);

    }

    @Test
    public void testTriad() {
        String hex = "#a09678";
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(hex);
        String[] triad = calculateRelatedColors.returnTriad();

        String[] hexValues = {"#a09678","#78a096","#9678a0"};

        Assert.assertArrayEquals(hexValues, triad);

    }

    @Test
    public void testAnalogous() {
        String hex = "#a09678";
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(hex);
        String[] analogous = calculateRelatedColors.returnAnalogous();

        String[] hexValues = {"#a09678","#9da078","#a08978"};

        Assert.assertArrayEquals(hexValues, analogous);

    }

    @Test
    public void testTetrad() {
        String hex = "#a09678";
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(hex);
        String[] tetrad = calculateRelatedColors.returnTetrad();

        String[] hexValues = {"#a09678","#7882a0","#96a078", "#8278a0"};

        Assert.assertArrayEquals(hexValues, tetrad);

    }

    @Test
    public void testTetradSquare() {
        String hex = "#a09678";
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(hex);
        String[] tetradSquare = calculateRelatedColors.returnTetradSquare();

        String[] hexValues = {"#a09678","#78a082","#7882a0", "#a07896"};

        Assert.assertArrayEquals(hexValues, tetradSquare);

    }

    @Test
    public void testBmpFileFormat() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("TestResources/bmp test.bmp");
        Assert.assertNotNull(is);

        LinkedList<Pixel> pixels = new ScanPictureForColors(new Image(is)).returnPixelList();

        Assert.assertEquals((630 * 354),pixels.size());

        

    }

    public LinkedList<Pixel> LoadPixelTestArray() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("TestResources/smallTest.png");
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors(new Image(is));
        LinkedList<Pixel> pixels = scanPictureForColors.returnPixelList();
        return pixels;
    }

    private LinkedList<Pixel> LoadLargePixelTestArray() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("TestResources/Test.jpg");
        ScanPictureForColors scanPictureForColors = new ScanPictureForColors(new Image(is));
        LinkedList<Pixel> pixels = scanPictureForColors.returnPixelList();
        return pixels;
    }
}
