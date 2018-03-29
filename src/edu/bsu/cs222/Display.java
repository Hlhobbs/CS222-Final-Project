package edu.bsu.cs222;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Display holds values so the values are in order for tableview

public class Display implements Serializable {

    Image image;

    private SimpleStringProperty hex = new SimpleStringProperty();

    private int count = 0;

    Display(){
    }

    //This portion does not do anything in the final code
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

    public int getCount() {
        return count;
    }

    public void addToCount() {
        this.count = count + 1;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
