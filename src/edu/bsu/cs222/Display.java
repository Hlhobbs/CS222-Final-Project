package edu.bsu.cs222;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.io.Serializable;

public class Display implements Serializable {

    Image image;
    private SimpleStringProperty hex = new SimpleStringProperty();

    //Data type which hold data to be displayed within out tableView
    Display(){
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
