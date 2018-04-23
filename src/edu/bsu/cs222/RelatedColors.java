package edu.bsu.cs222;

public class RelatedColors {


    //Container class for colors related to an element in the pixel

    private String complementary;
    private String[] triad;

    RelatedColors(String s) {
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(s);
        this.complementary = calculateRelatedColors.returnCompColor();
        this.triad = calculateRelatedColors.returnTriad();


    }

    public String getComplementary() {
        return complementary;
    }

    public String[] getTriad() {
        return triad;
    }
}
