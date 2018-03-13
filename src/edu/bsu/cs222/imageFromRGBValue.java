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

    //Sets default size for images to be contained within the table
    private int defaultWidth = 10;
    private int defaultHeight = 10;

    private Image returnImage;

    public imageFromRGBValue(Pixel pixel) {

        red = pixel.getRedValue();
        green = pixel.getGreenValue();
        blue = pixel.getBlueValue();
        alpha = pixel.getAlphaValue();


        Color color = new Color(red,green,blue,alpha);

        WritableImage wImage = new WritableImage(defaultWidth,defaultHeight);
        PixelWriter pixelWriter = wImage.getPixelWriter();

        for (int y = 0; y < defaultWidth; y++) {
            for ( int x = 0; x < defaultHeight; x++) {
                pixelWriter.setColor(x,y,color);
            }
        }

        this.returnImage = wImage;
    }

    public Image returnImage() {
        return returnImage;
    }
}
