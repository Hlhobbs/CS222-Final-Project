package edu.bsu.cs222;


import org.junit.jupiter.api.Test;


import javafx.*;


import java.awt.*;

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

}
