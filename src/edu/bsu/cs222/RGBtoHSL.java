package edu.bsu.cs222;


public class RGBtoHSL {

    private double H;
    private double S;
    private double L;

    RGBtoHSL(double r, double g, double b) {

        double rPrime = r/255;
        double gPrime = g/255;
        double bPrime = b/255;

        hue(rPrime,gPrime,bPrime);

        lumiance(rPrime,gPrime,bPrime);

        saturation(rPrime,gPrime,bPrime);



    }

    private void saturation(double r, double g, double b) {
        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g,b));

        double delta = max - min;

        if (delta == 0) {
            this.S = 0;
        } else {
            this.S = delta/(1 - Math.abs(2*this.L - 1));
        }
    }

    private void hue(double r, double g, double b) {
        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g,b));

        double delta = max - min;
        double Hprime = 0;

        if ( delta == 0) {
            Hprime = 0;
        } else if (max == r) {
            Hprime = ((g -b)/delta) % 6;
        } else if (max == g) {
            Hprime = ((b - r)/delta) + 2;
        } else if (max == b) {
            Hprime = ((r - g) / delta) + 4;
        }

        this.H = Hprime * 60;
    }

    private void lumiance(double r, double g, double b) {
        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g,b));
        this.L = ((max + min) / 2);
    }

    public double getH() {
        return H;
    }

    public double getS() {
        return S;
    }

    public double getL() {
        return L;
    }
}
