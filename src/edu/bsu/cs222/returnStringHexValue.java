package edu.bsu.cs222;


public class returnStringHexValue {

    public String returnStringHexValue(Pixel pixel)
    {

        double redDouble = pixel.getRedValue();
        double blueDouble = pixel.getBlueValue();
        double greenDouble = pixel.getGreenValue();
        Long redLong = Math.round(redDouble);
        int redInt = Integer.valueOf(redLong.intValue());
        Long blueLong = Math.round(blueDouble);
        int blueInt = Integer.valueOf(blueLong.intValue());
        Long greenLong = Math.round(greenDouble);
        int greenInt = Integer.valueOf(greenLong.intValue());

        String hex = String.format("#%02x%02x%02x",redInt,greenInt,blueInt);

        return hex;

    }
}
