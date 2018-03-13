package edu.bsu.cs222;

import javafx.scene.image.Image;

public class Pixel {

    //Will be used in future iterations
    private int xCoordinate;
    private int yCoordinate;

    private double redValue;
    private double greenValue;
    private double blueValue;
    private double alphaValue;

    public void setX_Coordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public void setY_Coordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }


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
}
