package edu.bsu.cs222;

import javafx.scene.image.Image;

public class Pixel {

    private int xCoordinate;
    private int yCoordinate;

    private double redValue;
    private double greenValue;
    private double blueValue;
    private double alphaValue;
    private Image color;
    //will probably break
    private Pixel hex;

    public int getxCoordinate() {
        return xCoordinate;
    }
    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public void setyCoordinate(int yCoordinate) {
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

    public Image getColor() {
        return color;
    }

    public void setColor(Image color) {
        this.color = color;
    }

    public Pixel getHex() {
        return hex;
    }

    public void setHex(Pixel hex) {
        this.hex = hex;
    }
}
