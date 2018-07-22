package ru.orbot90.hillsandpits;

import ru.orbot90.hillsandpits.error.InvalidLandscapeException;

public class WaterCalculatorImpl implements WaterCalculator {

    /**
     * {@inheritDoc}
     */
    public long calculateWaterAmount(int[] landscape) {
        this.validateLandScape(landscape);
        return this.calculateNumberOfFilledSquares(landscape);
    }

    private long calculateNumberOfFilledSquares(int[] landscape) {
        int lastPeak;
        int lastBottom;

        if (landscape.length > 0) {
            lastPeak = landscape[0];
            lastBottom = landscape[0];
        } else {
            lastPeak = 0;
            lastBottom = 0;
        }

        CalculationContext calculationContext = new CalculationContext();

        for (int currentHeight : landscape) {
            if (calculationContext.getCurrentTrend() == CalculationContext.TrendDirection.ASCENDING) {
                if (currentHeight >= lastPeak) {
                    lastPeak = currentHeight;
                    calculationContext.addHeightToPit(currentHeight);
                } else {
                    calculationContext.startDescending(currentHeight);
                }
            } else {
                if (currentHeight <= lastBottom) {
                    lastBottom = currentHeight;
                    calculationContext.addHeightToPit(currentHeight);
                } else {
                    calculationContext.startAscending(currentHeight);
                }
            }
        }

        return calculationContext.getCalculatedAmountOfWater();
    }

    private void validateLandScape(int[] landscape) {
        if (landscape.length > 32000) {
            throw new InvalidLandscapeException("Landscape has too many positions");
        }

        for (int i = 0; i < landscape.length; i++) {
            int height = landscape[i];
            if (height < 0 || height > 32000) {
                throw new InvalidLandscapeException(String.format("Illegal height on position %s. Given height is %s", i, height));
            }
        }
    }



}
