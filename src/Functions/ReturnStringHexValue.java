package Functions;


public class ReturnStringHexValue {


    private Pixel pixel;

    public ReturnStringHexValue(Pixel p) {
        this.pixel = p;
    }

    // ReturnStringHexValue takes a pixel with RBG values and takes the values to return a string with the hex value for the pixel.

    public String returnStringHexValue()
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
