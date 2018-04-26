package Functions;

import javafx.scene.image.Image;

import java.util.LinkedList;

public class CreatePixelList {

    private LinkedList<Pixel> pixelList;

    //CreatePixelList creates a list of the pixels in an images, and then deletes repeats and rarely used colors according to how the user wishes
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
