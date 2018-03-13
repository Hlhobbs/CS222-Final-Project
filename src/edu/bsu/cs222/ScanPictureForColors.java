package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import java.util.ArrayList;
import java.util.List;

public class ScanPictureForColors {



    public ObservableList<Pixel> ScanPixelsforColors(Image image) {

        ObservableList<Pixel> ScannedPixels = FXCollections.observableArrayList();

        double w = image.getWidth();
        double h = image.getHeight();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                Pixel datapixel = new Pixel();
                datapixel.setxCoordinate(j);
                datapixel.setyCoordinate(i);

                PixelReader pixelReader =image.getPixelReader();
                int picturePixel = pixelReader.getArgb(j,i);

                datapixel.setAlphaValue( (picturePixel >> 24) & 0xff);
                datapixel.setRedValue( (picturePixel >> 16) & 0xff );
                datapixel.setGreenValue( (picturePixel >> 8) & 0xff);
                datapixel.setBlueValue( (picturePixel) & 0xff);

                ScannedPixels.add(datapixel);

            }
        }
        return ScannedPixels;
    }
}
