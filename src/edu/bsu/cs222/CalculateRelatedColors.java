package edu.bsu.cs222;

public class CalculateRelatedColors {


    private final double red;
    private final double green;
    private final double blue;

    CalculateRelatedColors(String s) {
        this.red = Integer.parseInt(s.substring(1,3),16);
        this.green = Integer.parseInt(s.substring(3,5),16);
        this.blue = Integer.parseInt(s.substring(5,7),16);

        System.out.println(red);
        System.out.println(green);
        System.out.println(blue);
    }

    public String returnCompColor() {
        double[] HSL = new RGBtoHSL(red,green,blue).getHSL();
        if (HSL[0] > 180) {
            HSL[0] = HSL[0] - 180;
        } else if (HSL[0] < 180) {
            HSL[0] = HSL[0] + 180;
        }
        String hex = new HSLtoHex(HSL).returnHex();
        return hex;

    }

}
