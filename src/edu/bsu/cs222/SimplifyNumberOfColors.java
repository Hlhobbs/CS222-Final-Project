package edu.bsu.cs222;

import java.util.*;

//SimplifyNumberOfColors removes repeated colors while keeping a count of how many times a individual color is displayed

class SimplifyNumberOfColors {

    private LinkedList<Pixel> pixelList;

    SimplifyNumberOfColors(LinkedList<Pixel> list) {

        long start = System.nanoTime();

        HashMap<String,Pixel> colorsAndCounts = new HashMap<>();

        for (Pixel pixel :
                list) {
            if (!colorsAndCounts.containsKey(pixel.getHexValue())) {
                colorsAndCounts.put(pixel.getHexValue(),pixel);
                pixel.setCount(1);
            }
            else
                colorsAndCounts.get(pixel.getHexValue()).increaseby1();
        }

        pixelList = new LinkedList<>(colorsAndCounts.values());

        System.out.println(((System.nanoTime()-start)/1000000.0)+" millisec");
    }

    LinkedList<Pixel> returnShrunkList() {
        return this.pixelList;
    }

    //DeleteRareColors is a method that takes the number from MinimumUsesFromTextField and uses it to get rid of colors that appear less than that number.

    void DeleteRareColors(int uses) {
        pixelList.removeIf(pixel -> pixel.getCount() < uses);
    }
}
