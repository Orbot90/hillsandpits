package ru.orbot90.hillsandpits;

import org.junit.Test;
import ru.orbot90.hillsandpits.error.InvalidLandscapeException;

import static org.junit.Assert.assertEquals;

public class WaterCalculatorTest {

    private final WaterCalculatorImpl waterCalculator = new WaterCalculatorImpl();

    @Test
    public void shouldFillNineSquares() {
        int[] landscape = {5,2,3,4,5,4,0,3,1};
        long filledSquaresCount = waterCalculator.calculateWaterAmount(landscape);
        assertEquals("Wrong amount of filled squares", 9, filledSquaresCount);
    }

    @Test
    public void shouldFillZeroSquaresGivenEmptyLandscape() {
        int[] landscape = {};
        long filledSquaresCount = waterCalculator.calculateWaterAmount(landscape);
        assertEquals("Wrong amount of filled squares", 0, filledSquaresCount);
    }

    @Test
    public void shouldFillZeroSquaresGivenNoPits() {
        int[] landscape = {6,6,6,6,6,6,6};
        long filledSquaresCount = waterCalculator.calculateWaterAmount(landscape);
        assertEquals("Wrong amount of filled squares", 0, filledSquaresCount);
    }

    @Test
    public void shouldFillZeroSquaresGivenOnePeak() {
        int[] landscape = {0,0,0,7,0,0,0};
        long filledSquaresCount = waterCalculator.calculateWaterAmount(landscape);
        assertEquals("Wrong amount of filled squares", 0, filledSquaresCount);
    }

    @Test
    public void shouldFillTwoPitsGivenSmallHillBetweenBigHills() {
        int[] landscape = {9,5,4,0,0,3,0,0,9,4};
        long filledSquaresCount = waterCalculator.calculateWaterAmount(landscape);
        assertEquals("Wrong amount of filled squares", 12, filledSquaresCount);
    }

    @Test(expected = InvalidLandscapeException.class)
    public void shouldThrowErrorGivenTooLongLandscape() {
        int[] landscape = new int[32001];
        waterCalculator.calculateWaterAmount(landscape);
    }

    @Test(expected = InvalidLandscapeException.class)
    public void shouldThrowErrorGivenNegativeHeight() {
        int[] landscape = {0,5,6,-2,7,8};
        waterCalculator.calculateWaterAmount(landscape);
    }

    @Test(expected = InvalidLandscapeException.class)
    public void shouldThrowErrorGivenTooBigHeight() {
        int[] landscape = {0,5,6,32001,7,8};
        waterCalculator.calculateWaterAmount(landscape);
    }
}
