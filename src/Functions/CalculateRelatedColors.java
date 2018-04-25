package Functions;

public class CalculateRelatedColors {


    private static double[] HSL;

    //Assumes string s is a hex
    public CalculateRelatedColors(String s) {
        double red = Integer.parseInt(s.substring(1,3),16);
        double green = Integer.parseInt(s.substring(3,5),16);
        double blue = Integer.parseInt(s.substring(5,7),16);
        this.HSL = new RGBtoHSL(red,green,blue).getHSL();
    }

    public String returnCompColor() {
        double[] copyHSL = this.HSL;
        copyHSL[0] = FixHue(copyHSL[0] + 180);
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
        copyHSL[0] = FixHue(copyHSL[0] - 240);
        hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[2] = hexValue;

        return paletteHex;
    }

    public String[] returnTetrad()
    {
        String[] paletteHex = new String[4];

        double[] copyHSL = this.HSL;

        //Original color
        String hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[0] = hexValue;

        //Color 2 Comp color of original color
        copyHSL[0] = FixHue(copyHSL[0] + 180);
        hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[1] = hexValue;

        //Color 3 30 degrees of original color
        copyHSL[0] = FixHue((copyHSL[0] - 180) + 30);
        hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[2] = hexValue;

        //Color 4 Comp color of color 3
        copyHSL[0] = FixHue(copyHSL[0] + 180);
        hexValue = new HSLtoHex(copyHSL).returnHex();
        paletteHex[3] = hexValue;

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
