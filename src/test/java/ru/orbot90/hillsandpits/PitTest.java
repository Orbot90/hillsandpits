package ru.orbot90.hillsandpits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PitTest {

    @Test
    public void shouldCalculateTenSquaresOfWaterGivenLeftPeakHigher() {
        int[] pitLandscape = {5,3,2,1,0,0,2,3};
        Pit pit = new Pit();
        for(int height : pitLandscape) {
            pit.addHeightToPitLandscape(height);
        }
        long amountOfWater = pit.getCollectedAmountOfWater();
        assertEquals("Wrong amount of collected water", 10, amountOfWater);
    }

    @Test
    public void shouldCalculateTenSquaresOfWaterGivenRightPeakHigher() {
        int[] pitLandscape = {3,2,0,0,1,2,3,5};
        Pit pit = new Pit();
        for(int height : pitLandscape) {
            pit.addHeightToPitLandscape(height);
        }
        long amountOfWater = pit.getCollectedAmountOfWater();
        assertEquals("Wrong amount of collected water", 10, amountOfWater);
    }


}
