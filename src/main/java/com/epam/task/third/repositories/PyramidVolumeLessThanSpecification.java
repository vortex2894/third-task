package com.epam.task.third.repositories;

import com.epam.task.third.entities.IdentifiablePyramid;
import com.epam.task.third.logic.PyramidCalculator;

public class PyramidVolumeLessThanSpecification implements PyramidSpecification {

    private final PyramidCalculator calculator = new PyramidCalculator();
    private final double volume;

    public PyramidVolumeLessThanSpecification(double volume) {
        super();
        this.volume = volume;
    }

    @Override
    public boolean isSpecified(IdentifiablePyramid pyramid) {
        double actual = calculator.countVolume(pyramid);
        return actual < volume;
    }

}
