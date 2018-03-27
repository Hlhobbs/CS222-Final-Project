package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimplifyColors {

    private int count = 0;
    private ObservableList<String> observableList;

    public ObservableList<String> DeleteRepeatColors(ObservableList<String> list) {
        this.observableList = list;
        ObservableList<String> returnList = FXCollections.observableArrayList();
        while (observableList.isEmpty() != true) {
            String color = list.get(0);
            returnList.add(color);
            observableList.removeAll(color);
            System.out.println(list.size());
        }
        return returnList;
    }

    //public ObservableList<Display> CombineSimilarColors(ObservableList<Display> list) {
    //}

}
