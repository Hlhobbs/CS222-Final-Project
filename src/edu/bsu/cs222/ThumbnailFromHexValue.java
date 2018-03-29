package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ThumbnailFromHexValue {

    private Image returnImage;

    public ThumbnailFromHexValue(String h) {

        Color color = Color.web(h);

        int defaultWidth = 10;
        int defaultHeight = 10;
        WritableImage wImage = new WritableImage(defaultWidth, defaultHeight);
        PixelWriter pixelWriter = wImage.getPixelWriter();

        for (int y = 0; y < defaultWidth; y++) {
            for (int x = 0; x < defaultHeight; x++) {
                pixelWriter.setColor(x,y,color);
            }
        }

        this.returnImage = wImage;
    }

    public Image returnImage() {
        return returnImage;
    }
}
