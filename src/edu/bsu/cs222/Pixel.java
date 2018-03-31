package edu.bsu.cs222;

import javafx.beans.property.SimpleStringProperty;
import org.omg.PortableInterceptor.INACTIVE;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.LinkedList;

public class Pixel {

    //Will be used in future iterations
    private int xCoordinate;
    private int yCoordinate;

    private LinkedList<Integer> xCoordinateList = new LinkedList<Integer>();
    private LinkedList<Integer> yCoordinateList = new LinkedList<Integer>();

    private double redValue;
    private double greenValue;
    private double blueValue;
    private double alphaValue;

    private SimpleStringProperty hexValue = new SimpleStringProperty();

    private int count;

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
        return hexValue.get();
    }

    public void setHexValue() {
        String hex = new ReturnStringHexValue(this).returnStringHexValue();
        hexValue.set(hex);
    }

    public int getCount() {
        return count;
    }

    public void addToCount() {
        this.count = count + 1;
    }
}
