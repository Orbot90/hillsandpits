package ru.orbot90.hillsandpits;

import java.util.ArrayList;
import java.util.List;

/**
 * Object representing pit collecting water.
 */
class Pit {

    private List<Integer> pitLandscape = new ArrayList<Integer>();

    /**
     * Add height position to this pit landscape
     * @param height landscape position height
     */
    void addHeightToPitLandscape(int height) {
        this.pitLandscape.add(height);
    }

    /**
     * Get amount of water collected in this pit
     */
    long getCollectedAmountOfWater() {
        long amountOfWater = 0;
        if (pitLandscape.size() > 0) {
            int leftPeak = pitLandscape.get(0);
            int rightPeak = pitLandscape.get(pitLandscape.size()-1);

            int smallerPeak = leftPeak < rightPeak ? leftPeak : rightPeak;

            for (int height : pitLandscape) {
                if (smallerPeak - height > 0) {
                    amountOfWater += smallerPeak - height;
                }
            }
        }

        return amountOfWater;
    }

    int getRightPeak() {
        return this.pitLandscape.get(this.pitLandscape.size()-1);
    }
}
