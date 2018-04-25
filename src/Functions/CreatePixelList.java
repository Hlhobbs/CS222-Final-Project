package Functions;

import javafx.scene.image.Image;

import java.util.LinkedList;

public class CreatePixelList {

    private LinkedList<Pixel> pixelList;

    public CreatePixelList(Image image, int uses) {

         pixelList = new ScanPictureForColors(image).returnPixelList();


        SimplifyNumberOfColors sc = new SimplifyNumberOfColors(pixelList);
        sc.DeleteRareColors(uses);
        pixelList = sc.returnShrunkList();

    }

    public LinkedList<Pixel> returnList() {
        return this.pixelList;
    }
}
