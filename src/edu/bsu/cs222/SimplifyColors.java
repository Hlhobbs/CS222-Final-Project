package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimplifyColors {

    private List<Integer> count = new ArrayList<>();
    private List<String> observableList;

    public ObservableList<String> DeleteRepeatColors(List<String> list) {
        this.observableList = list;
        ObservableList<String> returnList = FXCollections.observableArrayList();
        while (observableList.isEmpty() != true) {
            String color = observableList.get(0);
            int indexBefore = observableList.size();
            returnList.add(color);
            observableList.removeAll(Collections.singleton(color));
            int indexAfter = observableList.size();
            int individualCount = indexBefore - indexAfter;
            this.count.add(individualCount);
            System.out.println(list.size());
        }
        return returnList;
    }

    public List<Integer> getCount() {
        return count;
    }

    //public ObservableList<Display> CombineSimilarColors(ObservableList<Display> list) {
    //}

}
