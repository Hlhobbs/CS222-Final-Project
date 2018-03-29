package edu.bsu.cs222;


public class ReturnStringHexValue {


    public ReturnStringHexValue() {
    }

    // ReturnStringHexValue takes a pixel with RBG values and takes the values to return a string with the hex value for the pixel.

    public String returnStringHexValue(Pixel pixel)
    {

        double redDouble = pixel.getRedValue();
        double blueDouble = pixel.getBlueValue();
        double greenDouble = pixel.getGreenValue();
        Long redLong = Math.round(redDouble);
        int redInt = redLong.intValue();
        Long blueLong = Math.round(blueDouble);
        int blueInt = blueLong.intValue();
        Long greenLong = Math.round(greenDouble);
        int greenInt = greenLong.intValue();

        return String.format("#%02x%02x%02x",redInt,greenInt,blueInt);

    }
}
