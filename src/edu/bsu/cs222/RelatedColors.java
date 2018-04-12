package edu.bsu.cs222;

public class RelatedColors {


    //Container class for colors related to an element in the pixel

    private String complementary;

    RelatedColors(String s) {
        CalculateRelatedColors calculateRelatedColors = new CalculateRelatedColors(s);
        this.complementary = calculateRelatedColors.returnCompColor();


    }

    public String getComplementary() {
        return complementary;
    }
}
