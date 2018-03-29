package edu.bsu.cs222;

import java.util.*;

//SimplifyColors removes repeated colors while keeping a count of how many times a individual color is displayed

public class SimplifyColors {

    private LinkedList<Integer> count = new LinkedList<>();

    public List<String> DeleteRepeatColors(LinkedList<String> list) {
        List<String> returnList = new ArrayList<>();
        while (!list.isEmpty()) {
            String color = list.get(0);
            int indexBefore = list.size();
            returnList.add(color);
            list.removeAll(Collections.singleton(color));
            int indexAfter = list.size();
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
