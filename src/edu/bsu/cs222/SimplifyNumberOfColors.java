package edu.bsu.cs222;

import java.util.*;

//SimplifyNumberOfColors removes repeated colors while keeping a count of how many times a individual color is displayed

public class SimplifyNumberOfColors {

    private LinkedList<Pixel> pixelList;

    public SimplifyNumberOfColors(LinkedList<Pixel> list) {
        this.pixelList = list;
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
        }
        pixelList = newList;
    }

    public LinkedList<Pixel> returnShrunkList() {
        return this.pixelList;
    }

    //DeleteRareColors is a method that takes the number from MinimumUsesFromTextField and uses it to get rid of colors that appear less than that number.

    public void DeleteRareColors(int uses) {
        Iterator<Pixel> iterator = pixelList.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getCount() < uses) {
                iterator.remove();
            }
        }
    }
}
