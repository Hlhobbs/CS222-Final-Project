package edu.bsu.cs222;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

//SimplifyColors removes repeated colors while keeping a count of how many times a individual color is displayed

public class SimplifyColors {

    private LinkedList<Integer> count = new LinkedList<>();
    private LinkedList<String> observableList;

    public List<String> DeleteRepeatColors(LinkedList<String> list) {
        this.observableList = list;
        List<String> returnList = new ArrayList();
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

    //public List<Display> CombineSimilarColors(List<Display> list) {
    //}

}
