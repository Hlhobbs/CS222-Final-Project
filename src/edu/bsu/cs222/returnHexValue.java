package edu.bsu.cs222;

import javafx.collections.ObservableList;

public class returnHexValue {

    Pixel pixel;

    public void returnHexValue(ObservableList<Pixel> list , int index ) {
        pixel = list.get(index);
    }

    public Pixel getPixel() {
        return pixel;
    }
}
