package Functions;


public class RelatedColors {


    //Container class for colors related to an element in the pixel

    private String complementary;
    private String[] triad;
    private String[] tetrad;

    public RelatedColors(String s) {
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(s);
        this.complementary = calculateRelatedColors.returnCompColor();
        this.triad = calculateRelatedColors.returnTriad();
        this.tetrad = calculateRelatedColors.returnTetrad();


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
}
