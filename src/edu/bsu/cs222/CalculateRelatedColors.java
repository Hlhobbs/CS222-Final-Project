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

    public String[] returnTriadColors() {

        double[] triad2HSL = this.HSL;

        if (triad2HSL[0] + 120 > 360) {
            triad2HSL[0] = (triad2HSL[0] + 120) - 360;
        } else {
            triad2HSL[0] = triad2HSL[0] + 120;
        }

        double[] triad3HSL = triad2HSL;

        if (triad3HSL[0] + 120 > 360) {
            triad3HSL[0] = (triad3HSL[0] + 120) - 360;
        } else {
            triad3HSL[0] = triad3HSL[0] + 120;
        }

        String[] triads = new String[3];
        triads[0] = new HSLtoHex(HSL).returnHex();
        triads[1] = new HSLtoHex(triad2HSL).returnHex();
        triads[2] = new HSLtoHex(triad3HSL).returnHex();
        return triads;
    }

}
