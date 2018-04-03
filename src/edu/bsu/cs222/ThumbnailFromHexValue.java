package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

class ThumbnailFromHexValue {

    private Image returnImage;

    ThumbnailFromHexValue(String h) {

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

    Image returnImage() {
        return returnImage;
    }
}
