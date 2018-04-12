package edu.bsu.cs222;

public class CalculateRelatedColors {


    private static double[] HSL;

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
}
