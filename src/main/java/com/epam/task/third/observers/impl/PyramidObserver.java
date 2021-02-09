package com.epam.task.third.observers.impl;

import com.epam.task.third.logic.PyramidCalculator;
import com.epam.task.third.observers.Observer;
import com.epam.task.third.observers.Parameters;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer {

    private final PyramidCalculator calculator;
    private final Map<Long, Parameters> parameters;
    private static PyramidObserver INSTANCE;

    private PyramidObserver() {
        calculator = new PyramidCalculator();
        parameters = new HashMap<>();
    }

    public static PyramidObserver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PyramidObserver();
        }
        return INSTANCE;
    }

    @Override
    public void update(PyramidObservable pyramid) {
        Parameters params = calculateParameters(pyramid);
        parameters.put(pyramid.getId(), params);
    }

    private Parameters calculateParameters(PyramidObservable pyramid) {
        double area = calculator.countSurfaceArea(pyramid);
        double volume = calculator.countVolume(pyramid);
        return new Parameters(area, volume);
    }

    public double getPyramidVolume(Long id) {
        Parameters params = parameters.get(id);
        return params.getVolume();
    }

    public double getPyramidSurfaceArea(Long id) {
        Parameters params = parameters.get(id);
        return params.getSurfaceArea();
    }
}
