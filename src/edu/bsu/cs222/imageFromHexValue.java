package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class imageFromHexValue {

    private double red;
    private double green;
    private double blue;
    private double opacity = 1;

    private int defaultW = 10;
    private int defaultH = 10;

    public Image imageFromHexValue(double r, double g, double b) {

        red = r;
        green = g;
        blue = b;


        Color color = new Color(r,g,b, opacity);

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
