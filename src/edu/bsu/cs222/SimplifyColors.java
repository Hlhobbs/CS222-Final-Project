package edu.bsu.cs222;

import java.util.*;

//SimplifyColors removes repeated colors while keeping a count of how many times a individual color is displayed

public class SimplifyColors {

    private LinkedList<Pixel> pixelList;
    private LinkedList<Integer> count = new LinkedList<>();

    public SimplifyColors(LinkedList<Pixel> list) {
        this.pixelList = list;
    }

    public void DeleteRepeatColors(){
        LinkedList<Pixel> newList = new LinkedList<>();
        while (!pixelList.isEmpty()) {
            Pixel color = pixelList.get(0);
            int indexBefore = pixelList.size();
            newList.add(color);

            Iterator<Pixel> itr = pixelList.iterator();
            while (itr.hasNext()) {
                if (itr.next().getHexValue().matches(color.getHexValue())) {
                    itr.remove();
                }
            }

            int indexAfter = pixelList.size();
            int individualCount = indexBefore - indexAfter;
            newList.getLast().setCount(individualCount);
            System.out.println(pixelList.size());
        }
        pixelList = newList;
    }

    public LinkedList<Pixel> returnShrunkList() {
        return this.pixelList;
    }
}
