package edu.bsu.cs222;


public class returnStringHexValue {

    public String returnStringHexValue(Pixel pixel)
    {

        double reddouble = pixel.getRedValue();
        double bluedouble = pixel.getBlueValue();
        double greendouble = pixel.getGreenValue();
        Long redlong = Math.round(reddouble);
        int redint = Integer.valueOf(redlong.intValue());
        Long bluelong = Math.round(bluedouble);
        int blueint = Integer.valueOf(bluelong.intValue());
        Long greenlong = Math.round(greendouble);
        int greenint = Integer.valueOf(greenlong.intValue());

        String hex = String.format("#%02x%02x%02x",redint,greenint,blueint);

        return hex;

    }
}
