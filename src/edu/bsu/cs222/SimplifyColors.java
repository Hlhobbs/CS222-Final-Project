package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SimplifyColors {

    private int count = 0;

    public ObservableList<String> DeleteRepeatColors(ObservableList<String> list) {
        ObservableList<String> returnList = FXCollections.observableArrayList();
        while (list.isEmpty() != true) {
            String color = list.get(0);
            returnList.add(color);
            list.removeAll(color);
            System.out.println(list.size());
        }
        return returnList;
    }


    //public ObservableList<Display> CombineSimilarColors(ObservableList<Display> list) {
    //}

}
