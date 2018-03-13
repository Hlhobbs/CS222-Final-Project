package edu.bsu.cs222;

public class returnStringHexValue {

    public String returnStringHexValue(Pixel pixel)
    {
        double red = pixel.getRedValue();
        double blue = pixel.getBlueValue();
        double green = pixel.getGreenValue();

        String hex = String.format("#%02x%02x%02x",red,green,blue);

        return hex;

    }
}
