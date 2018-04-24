package Functions;

import java.util.*;

//SimplifyNumberOfColors removes repeated colors while keeping a count of how many times a individual color is displayed

public class SimplifyNumberOfColors {

    private LinkedList<Pixel> pixelList;

    public SimplifyNumberOfColors(LinkedList<Pixel> list) {

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
    }

    public LinkedList<Pixel> returnShrunkList() {
        return this.pixelList;
    }

    //DeleteRareColors is a method that takes the number from MinimumUsesFromTextField and uses it to get rid of colors that appear less than that number.

    public void DeleteRareColors(int uses) {
        pixelList.removeIf(pixel -> pixel.getCount() < uses);
    }
}
