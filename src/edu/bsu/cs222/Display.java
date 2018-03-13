package edu.bsu.cs222;

import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;

public class Display {
    ImageView image;
    String hex;

    public Display(ImageView img, String hString){
        this.image = img;
        this.hex = hString;
    }

    public ObservableValue<ImageView> getImage(){
        return (ObservableValue<ImageView>) image;
    }

    public ObservableValue<String> getHex(){
        return this.hex;
    }

}
