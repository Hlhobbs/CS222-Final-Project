package Functions;


import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import java.util.LinkedList;

public class ScanPictureForColors {

/* ScanPixelsForColors takes an image and outputs an observable list of Pixels. The method scans the image and gets the RGB values
of each pixel in the image and populates the list with pixels each with RBG values.
 */

    private LinkedList<Pixel> ScannedPixels;
    private Pixel ScannedPixel;
    private Image image;

    public ScanPictureForColors(Image i) {
        this.image = i;
        ScannedPixels = new LinkedList<>();

        double w = image.getWidth();
        double h = image.getHeight();

        for (int k = 0; k < h; k++) {
            for (int j = 0; j < w; j++) {
                ScannedPixels.add(Scan(j,k));
            }
        }
    }


    public ScanPictureForColors(Image i, int x, int y) {
        this.image = i;
        this.ScannedPixel = Scan(x,y);
    }

    public LinkedList<Pixel> returnPixelList() {
        return this.ScannedPixels;
    }
    public Pixel returnPixel() { return this.ScannedPixel;}

    private Pixel Scan(int x, int y) {
        Pixel datapixel = new Pixel();
        datapixel.setX_Coordinate(x);
        datapixel.setY_Coordinate(y);

        PixelReader pixelReader = image.getPixelReader();
        int picturePixel = pixelReader.getArgb(x, y);

        datapixel.setAlphaValue((picturePixel >> 24) & 0xff);
        datapixel.setRedValue((picturePixel >> 16) & 0xff);
        datapixel.setGreenValue((picturePixel >> 8) & 0xff);
        datapixel.setBlueValue((picturePixel) & 0xff);
        datapixel.setColorCodes();

        return datapixel;
    }

}
