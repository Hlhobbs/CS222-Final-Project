package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ComplementaryColorsFromRGB {

    Pixel compPixel;

    ComplementaryColorsFromRGB(Pixel pixel) {
        double red = pixel.getRedValue();
        double green = pixel.getGreenValue();
        double blue = pixel.getBlueValue();

        double compRed = 255 - red;
        double compGreen = 255 - green;
        double compBlue = 255 - blue;

        compPixel = new Pixel();
        compPixel.setRedValue(compRed);
        compPixel.setGreenValue(compGreen);
        compPixel.setBlueValue(compBlue);
        compPixel.setHexValue();
    }

    public Pixel getCompPixel() {
        return compPixel;
    }
}
