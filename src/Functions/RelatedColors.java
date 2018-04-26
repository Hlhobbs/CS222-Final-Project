package Functions;


public class RelatedColors {


    //Container class for colors related to an element in the pixel

    private String complementary;
    private String[] triad;
    private String[] tetrad;
    private String[] splitcomp;
    private String[] tetradSquare;
    private String[] analogous;

    public RelatedColors(String s) {
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(s);
        this.complementary = calculateRelatedColors.returnCompColor();
        this.triad = calculateRelatedColors.returnTriad();
        this.tetrad = calculateRelatedColors.returnTetrad();
        this.splitcomp = calculateRelatedColors.returnSplitComp();
        this.tetradSquare = calculateRelatedColors.returnTetradSquare();
        this.analogous = calculateRelatedColors.returnAnalogous();



    }

    public String getComplementary() {
        return complementary;
    }

    public String[] getTriad() {
        return triad;
    }

    public String[] getTetrad() {
        return tetrad;
    }

    public String[] getSplitcomp() { return splitcomp; }

    public String[] getTetradSquare() { return tetradSquare; }

    public String[] getAnalogous() { return analogous; }
}
