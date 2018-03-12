package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class imageFromRGBValue {

    private double red;
    private double green;
    private double blue;
    private double alpha;

    private int defaultW = 10;
    private int defaultH = 10;

    public Image imageFromRGBValue(Pixel pixel) {

        red = pixel.getRedValue();
        green = pixel.getGreenValue();
        blue = pixel.getBlueValue();
        alpha = pixel.getAlphaValue();


        Color color = new Color(red,green,blue,alpha);

        WritableImage wImage = new WritableImage(defaultW,defaultH);
        PixelWriter pixelWriter = wImage.getPixelWriter();

        for (int y = 0; y < defaultW; y++) {
            for ( int x = 0; x < defaultH; x++) {
                pixelWriter.setColor(x,y,color);
            }
        }

        Image returnImage = wImage;
        return returnImage;
    }
}
