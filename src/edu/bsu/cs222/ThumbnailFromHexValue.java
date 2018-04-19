package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

class ThumbnailFromHexValue {

    private Image returnImage;
    private int defaultWidth = 10;
    private int defaultHeight = 10;

    ThumbnailFromHexValue(String h) {

        Color color = Color.web(h);

        WritableImage wImage = new WritableImage(this.defaultWidth, this.defaultHeight);
        PixelWriter pixelWriter = wImage.getPixelWriter();

        for (int y = 0; y < defaultWidth; y++) {
            for (int x = 0; x < defaultHeight; x++) {
                pixelWriter.setColor(x,y,color);
            }
        }

        this.returnImage = wImage;
    }

    ThumbnailFromHexValue(String h, int height, int width) {
        Color color = Color.web(h);

        WritableImage wImage = new WritableImage(width, height);
        PixelWriter pixelWriter = wImage.getPixelWriter();

        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                pixelWriter.setColor(x,y,color);
            }
        }

        this.returnImage = wImage;
    }

    Image returnImage() {
        return returnImage;
    }
}
