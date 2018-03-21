package edu.bsu.cs222;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.io.Serializable;

public class Display implements Serializable {

    Image image;
    private SimpleStringProperty hex = new SimpleStringProperty();
    //private ObjectProperty thumbnail = new SimpleObjectProperty();

    //Data type which hold data to be displayed within out tableView
    Display(){
    }

    //For Image
    public Image getImage(){
        return image;
    }

    public void setImage(Image i) {
        this.image = i;
    }

    //For hex
    public void setHex(String h) {
        hex.set(h);
    }

    public String getHex() {
        return hex.get();
    }

    public SimpleStringProperty hexProperty() {
        return hex;
    }
}
