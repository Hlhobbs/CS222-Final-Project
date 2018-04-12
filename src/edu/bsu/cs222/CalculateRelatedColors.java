package edu.bsu.cs222;

public class CalculateRelatedColors {


    private static double[] HSL;

    //Assumes string s is a hex
    CalculateRelatedColors(String s) {
        double red = Integer.parseInt(s.substring(1,3),16);
        double green = Integer.parseInt(s.substring(3,5),16);
        double blue = Integer.parseInt(s.substring(5,7),16);
        this.HSL = new RGBtoHSL(red,green,blue).getHSL();
    }

    public String returnCompColor() {
        double[] copyHSL = this.HSL;
        if (copyHSL[0] > 180) {
            copyHSL[0] = copyHSL[0] - 180;
        } else if (copyHSL[0] < 180) {
            copyHSL[0] = copyHSL[0] + 180;
        }
        String hex = new HSLtoHex(copyHSL).returnHex();
        return hex;
    }
/*
    public String[] returnTriad(Pixel pixel)
    {
        String[] paletteHex = new String[8];
        int[]    P5Colors   = new int[8];

        RGBtoHSL hslValues = new RGBtoHSL(pixel.getRedValue(),pixel.getGreenValue(),pixel.getBlueValue());
        double[] hsl = new double[3];
        hsl[0]= hslValues.getH();
        hsl[1]= hslValues.getS();
        hsl[2]= hslValues.getL();


        String hexValue = new HSLtoHex(hsl).returnHex();

        //hex.toUpperCase().replace("#", "");
        //baseColorHex = correctColorHex(hex);

        //float[] hsl = Hex2HSL(baseColorHex);

        double H = hslValues.getH();
        double S = hslValues.getS();
        double L = hslValues.getL();

        double H1 = FixHue(H + 120);
        double H2 = FixHue(H - 120);

        // Color 1 (Corrected base color)
        paletteHex[0] = hexValue;
        P5Colors[0]   = Hex2P5(paletteHex[0]);
        // Color 2
        hsl[0] = H1;
        hexValue = new HSLtoHex(hsl).returnHex();
        paletteHex[1] = hexValue;
        P5Colors[1]   = Hex2P5(paletteHex[1]);
        // Color 3
        paletteHex[2] = "FFFFFF";
        P5Colors[2]   = Hex2P5(paletteHex[2]);

        // Color 4
        hsl[0] = H2;
        hexValue = new HSLtoHex(hsl).returnHex();
        paletteHex[3] = hexValue;
        P5Colors[3]   = Hex2P5(paletteHex[3]);
/*
        // Color 5
        P5Colors[4]  = Hex2P5(SecondColor(paletteHex[0]));
        // Color 6
        P5Colors[5]  = Hex2P5(SecondColor(paletteHex[1]));
        // Color 7
        P5Colors[6]  = Hex2P5(SecondColor(paletteHex[2]));
        // Color 8
        P5Colors[7]  = Hex2P5(SecondColor(paletteHex[3]));

        // Return array with Processing colors
        */
       // return paletteHex;
    //}


    private double FixHue(double hue) {
        if (hue < 0) {
            return hue + 360;
        } else if (hue > 360) {
            return hue - 360;
        } else {
            return hue;
        } // if (hue < 0)
    } // FixHue()

}
