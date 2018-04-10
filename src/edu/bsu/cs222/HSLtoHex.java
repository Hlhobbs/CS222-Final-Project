package edu.bsu.cs222;

public class HSLtoHex {

    private String hex;

    public HSLtoHex(double[] hsl) {
        double chroma = (1 - Math.abs(2*hsl[2]-1)) * hsl[1];
        double x = chroma * (1 - Math.abs(
                (hsl[0] / 60) % 2 - 1
        ));
        double m = hsl[2] - chroma/2;
        double rPrime = 0, gPrime = 0, bPrime = 0;

        if ((hsl[0] >= 0) && (hsl[0] < 60)) {
            rPrime = chroma;
            gPrime = x;
            bPrime = 0;

        } else if ((hsl[0] >= 60) && (hsl[0] < 120)) {
            rPrime = x;
            gPrime = chroma;
            bPrime = 0;

        } else if ((hsl[0] >= 120) && (hsl[0] < 180)) {
            rPrime = 0;
            gPrime = chroma;
            bPrime = x;

        } else if ((hsl[0] >= 180) && (hsl[0] < 240)) {
            rPrime = 0;
            gPrime = x;
            bPrime = chroma;

        } else if ((hsl[0] >= 240) && (hsl[0] < 300)) {
            rPrime = x;
            gPrime = 0;
            bPrime = chroma;

        } else if ((hsl[0] >= 300) && (hsl[0] < 360)) {
            rPrime = chroma;
            gPrime = 0;
            bPrime = x;

        }

        double red = (rPrime + m) *255;
        double green = (gPrime + m) *255;
        double blue = (bPrime + m) * 255;

        System.out.println(red);
        System.out.println(green);
        System.out.println(blue);

        Long redLong = Math.round(red);
        int redInt = redLong.intValue();
        Long blueLong = Math.round(blue);
        int blueInt = blueLong.intValue();
        Long greenLong = Math.round(green);
        int greenInt = greenLong.intValue();

        this.hex = String.format("#%02x%02x%02x",redInt,greenInt,blueInt);

    }

    public String returnHex() {
        return hex;
    }
}
