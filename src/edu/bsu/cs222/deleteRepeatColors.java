package edu.bsu.cs222;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class deleteRepeatColors {

    public ArrayList<String> deleteRepeatColors(ObservableList<Pixel> Listofpixels)
    {

        returnStringHexValue getHexValues = new returnStringHexValue();
        ArrayList<String> hexvalues = new ArrayList<>();

        for (Pixel pixel: Listofpixels)
        {
            hexvalues.add(getHexValues.returnStringHexValue(pixel));
        }

        for (int i = 0; i < hexvalues.size()-1; i++) {
            for (int j = 0; j < hexvalues.size()-2; j++) {

                if (hexvalues.get(i).equals(hexvalues.get(j)))
                {
                    hexvalues.remove(j);
                }

            }
        }

        return hexvalues;
    }
}
