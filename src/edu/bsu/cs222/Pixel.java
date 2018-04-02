package edu.bsu.cs222;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import java.io.Serializable;
import java.util.LinkedList;

public class Pixel implements Serializable {

    //Will be used in future iterations
    private int xCoordinate;
    private int yCoordinate;

    private LinkedList<Integer> xCoordinateList = new LinkedList<Integer>();
    private LinkedList<Integer> yCoordinateList = new LinkedList<Integer>();

    private double redValue;
    private double greenValue;
    private double blueValue;
    private double alphaValue;


    private SimpleStringProperty hex = new SimpleStringProperty();
    private int count  = 1;

    Pixel() {}

    //The X and Y coordinate are not currently in use, but will be for features being implemented in iteration #3, so they have been prepared in advance
    public void setX_Coordinate(int xCoordinate) {this.xCoordinate = xCoordinate;}
    public int getX_Coordinate() {return this.xCoordinate;}

    public void setY_Coordinate(int yCoordinate) {this.yCoordinate = yCoordinate; }
    public int getY_Coordinate() {return this.yCoordinate;}

    public double getRedValue() {
        return redValue;
    }
    public double getGreenValue() {
        return greenValue;
    }
    public double getBlueValue() {
        return blueValue;
    }

    public void setRedValue(double redValue) {
        this.redValue = redValue;
    }
    public void setGreenValue(double greenValue) {
        this.greenValue = greenValue;
    }
    public void setBlueValue(double blueValue) {
        this.blueValue = blueValue;
    }

    public double getAlphaValue() {
        return alphaValue;
    }
    public void setAlphaValue(double alphaValue) {
        this.alphaValue = alphaValue;
    }

    public String getHexValue() {
        return hex.get();
    }
    //Used by tableView
    public SimpleStringProperty hexProperty() {return hex;}
    public void setHexValue() {
        String h = new ReturnStringHexValue(this).returnStringHexValue();
        hex.set(h);
    }

    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}
}
