package Functions;

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

    public ThumbnailFromHexValue(String h, int height, int width) {
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

    public Image returnImage() {
        return returnImage;
    }
}
