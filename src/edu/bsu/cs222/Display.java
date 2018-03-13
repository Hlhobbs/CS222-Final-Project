package edu.bsu.cs222;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.io.Serializable;

class Display implements Serializable {

    public Display() {
    }

    private Image image;
    private SimpleStringProperty simpleHex = new SimpleStringProperty();

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public SimpleStringProperty getSimpleHex() {
        return simpleHex;
    }

    public SimpleStringProperty setSimpleHex(String hex) {
        this.simpleHex.set(hex);
        return this.simpleHex;
    }
}