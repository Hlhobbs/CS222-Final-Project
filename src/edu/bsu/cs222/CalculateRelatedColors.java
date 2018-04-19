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

    public String[] returnTriad()
    {
        String[] paletteHex = new String[3];

        double[] copyHSL = this.HSL;


        //Original color
        String hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[0] = hexValue;

        // Color 2
        copyHSL[0] = FixHue(copyHSL[0] + 120);
        hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[1] = hexValue;


        // Color 3
        copyHSL[0] = FixHue(copyHSL[0] - 120);
        hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[2] = hexValue;


       return paletteHex;
    }


    private double FixHue(double hue) {
        if (hue < 0) {
            return hue + 360;
        } else if (hue > 360) {
            return hue - 360;
        } else {
            return hue;
        }
    }

}
