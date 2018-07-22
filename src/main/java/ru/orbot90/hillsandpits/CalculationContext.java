package ru.orbot90.hillsandpits;

/**
 * Context for storing current calculation state.
 * Not thread-safe, should not be shared between threads
 */
class CalculationContext {

    private Pit currentPit;
    private long calculatedAmountOfWater;
    private TrendDirection currentTrend = TrendDirection.ASCENDING;

    void addHeightToPit(int height) {
        if (this.currentPit == null) {
            this.startNewPit();
        }
        this.currentPit.addHeightToPitLandscape(height);
    }

    void startDescending(int currentHeight) {
        this.startNewPit();
        this.addHeightToPit(currentHeight);
        this.currentTrend = TrendDirection.DESCENDING;
    }

    long getCalculatedAmountOfWater() {
        return calculatedAmountOfWater;
    }

    TrendDirection getCurrentTrend() {
        return currentTrend;
    }

    private void startNewPit() {
        Integer pitStart = null;
        if (currentPit != null) {
            calculatedAmountOfWater += currentPit.getCollectedAmountOfWater();
            pitStart = currentPit.getRightPeak();
        }

        currentPit = new Pit();
        if (pitStart != null) {
            this.addHeightToPit(pitStart);
        }
    }

    void startAscending(int currentHeight) {
        this.addHeightToPit(currentHeight);
        this.currentTrend = TrendDirection.ASCENDING;
    }


}
