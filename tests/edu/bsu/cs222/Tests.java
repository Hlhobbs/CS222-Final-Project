package edu.bsu.cs222;


import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Tests {

    //When using the exampleImage, the LinkedList HexValues should contain the following values [#000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ffffff, #000000, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #ffffff, #ff0000, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #ffffff, #24ff00, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ffffff, #f0ff00, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d, #ffffff, #ff5b8d]
    //When using the exampleImage, the LinkedList, ShrinkedHexValues should contain the following values [#000000, #ffffff, #ff0000, #24ff00, #f0ff00, #ff5b8d]


    @Test
    public void testPixel() {
        Pixel pixel = new Pixel();
        pixel.setAlphaValue(12);
        Assert.assertEquals(12, pixel.getAlphaValue(), 0);
    }


    /**
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

    @Test
    public void testSimplifyColors() {
        LinkedList<String> testColors = new LinkedList<>();
        LinkedList<Integer> testCount = new LinkedList<>();
        testColors.add("#000000");
        testColors.add("#000000");
        testColors.add("#000000");
        testColors.add("#ffffff");

        List<String> returnList = new ArrayList();
        while(!testColors.isEmpty()) {
            String color = testColors.get(0);
            int indexBefore = testColors.size();
            returnList.add(color);
            testColors.removeAll(Collections.singleton(color));
            int indexAfter = testColors.size();
            int individualCount = indexBefore - indexAfter;
            testCount.add(individualCount);
        }
        LinkedList<Integer> expectedCount = new LinkedList<>();
        expectedCount.add(3);
        expectedCount.add(1);

        Assert.assertEquals(expectedCount, testCount);
    }
    **/
}
