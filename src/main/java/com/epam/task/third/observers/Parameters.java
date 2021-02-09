package com.epam.task.third.observers;

public class Parameters {

    private final double pyramidSurfaceArea;
    private final double pyramidVolume;

    public Parameters(double pyramidSurfaceArea, double pyramidVolume) {
        this.pyramidSurfaceArea = pyramidSurfaceArea;
        this.pyramidVolume = pyramidVolume;
    }

    public double getSurfaceArea() {
        return pyramidSurfaceArea;
    }

    public double getVolume() {
        return pyramidVolume;
    }
}
