package edu.bsu.cs222;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Display implements Serializable {
    Image image;
    SimpleStringProperty hex = new SimpleStringProperty();

    public Display(){
    }

    public Image getImage(){
        return image;
    }

    public void setImage(Image i) {
        this.image = i;
    }

    public SimpleStringProperty getHex(){
        return hex;
    }

    public void setHex(SimpleStringProperty s) {
        this.hex = s;
    }



}
