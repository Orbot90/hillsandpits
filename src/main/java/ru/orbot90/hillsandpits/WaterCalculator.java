package ru.orbot90.hillsandpits;

import ru.orbot90.hillsandpits.error.InvalidLandscapeException;

/**
 * Calculator of the water collected in pits
 */
public interface WaterCalculator {

    /**
     * Calculate the amount of water gathered in pits
     *
     * @param landscape - landscape array consisting of heights of hills
     * @return number of the squares filled with water
     *
     * @throws InvalidLandscapeException when the landscape has illegal size or illegal height on any position
     */
    long calculateWaterAmount(int[] landscape);

}
