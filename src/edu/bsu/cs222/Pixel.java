package edu.bsu.cs222;

import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;
import java.util.LinkedList;

//Container class
public class Pixel implements Serializable {

    //X and Y values will be used in iteration #3
    private int xCoordinate;
    private int yCoordinate;

    private LinkedList<Integer> xCoordinateList = new LinkedList<>();
    private LinkedList<Integer> yCoordinateList = new LinkedList<>();

    private double redValue;
    private double greenValue;
    private double blueValue;
    private double alphaValue;


    private SimpleStringProperty hex = new SimpleStringProperty();
    private int count  = 1;

    Pixel() {}

    //The X and Y coordinate are not currently in use, but will be for features being implemented in iteration #3, so they have been prepared in advance
    void setX_Coordinate(int xCoordinate) {this.xCoordinate = xCoordinate;}
    public int getX_Coordinate() {return this.xCoordinate;}

    void setY_Coordinate(int yCoordinate) {this.yCoordinate = yCoordinate; }
    public int getY_Coordinate() {return this.yCoordinate;}

    double getRedValue() {
        return redValue;
    }
    double getGreenValue() {
        return greenValue;
    }
    double getBlueValue() {
        return blueValue;
    }

    void setRedValue(double redValue) {
        this.redValue = redValue;
    }
    void setGreenValue(double greenValue) {
        this.greenValue = greenValue;
    }
    void setBlueValue(double blueValue) {
        this.blueValue = blueValue;
    }

    double getAlphaValue() {
        return alphaValue;
    }
    void setAlphaValue(double alphaValue) {
        this.alphaValue = alphaValue;
    }

    String getHexValue() {
        return hex.get();
    }
    //Used by tableView
    public SimpleStringProperty hexProperty() {return hex;}
    void setHexValue() {
        String h = new ReturnStringHexValue(this).returnStringHexValue();
        hex.set(h);
    }

    //needs to be public for the tableView to access it
    public int getCount() {return count;}
    void setCount(int count) {this.count = count;}

    public void increaseby1() {
        count++;
    }
}
