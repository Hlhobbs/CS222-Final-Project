package edu.bsu.cs222;

import java.util.*;

//SimplifyNumberOfColors removes repeated colors while keeping a count of how many times a individual color is displayed

class SimplifyNumberOfColors {

    private LinkedList<Pixel> pixelList;

    SimplifyNumberOfColors(LinkedList<Pixel> list) {
        this.pixelList = list;
        LinkedList<Pixel> newList = new LinkedList<>();
        while (!pixelList.isEmpty()) {
            Pixel color = pixelList.get(0);
            int indexBefore = pixelList.size();
            newList.add(color);

            pixelList.removeIf(pixel -> pixel.getHexValue().matches(color.getHexValue()));
            int indexAfter = pixelList.size();
            int individualCount = indexBefore - indexAfter;
            newList.getLast().setCount(individualCount);
            System.out.println(pixelList.size());
        }
        pixelList = newList;
    }

    LinkedList<Pixel> returnShrunkList() {
        return this.pixelList;
    }

    //DeleteRareColors is a method that takes the number from MinimumUsesFromTextField and uses it to get rid of colors that appear less than that number.

    void DeleteRareColors(int uses) {
        pixelList.removeIf(pixel -> pixel.getCount() < uses);
    }
}
