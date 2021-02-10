package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PyramidCalculatorTest {

    private final static double DELTA = 0.01;
    private final static Point firstPoint = new Point(2, -1, 1);
    private final static Point secondPoint = new Point(5, 5, 4);
    private final static Point thirdPoint = new Point(3, 2, -1);
    private final static Point fourthPoint = new Point(4, 1, 3);
    private final static Pyramid TEST_PYRAMID = new Pyramid(firstPoint, secondPoint, thirdPoint, fourthPoint);
    private final static Pyramid PYRAMID_ON_PLANE = new Pyramid(Arrays.asList(0, 0, 0, 5, 0, 0, 3, 2, 0, 4, 5, 6));
    private final static Pyramid INVALID_PYRAMID = new Pyramid(Arrays.asList(0, 0, 0, 5, 0, 0, 3, 2, 0, 4, 0, 0));

    private final PyramidCalculator calculator = new PyramidCalculator();

    @Test
    public void testCountPyramidVolumeShouldCountVolumeWhenInputDataIsCorrect() {
        //given
        double expected = 3;
        //when
        double actual = calculator.countVolume(TEST_PYRAMID);
        //then
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCountPyramidVolumeShouldReturnZeroWhenPointsOnOnePlane() {
        //given
        double expected = 0;
        //when
        double actual = calculator.countVolume(INVALID_PYRAMID);
        //then
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCountPyramidSurfaceAreaShouldCountPyramidSurfaceAreaWhenInputDataIsCorrect() {
        //given
        double expected = 30.915;
        //when
        double actual = calculator.countSurfaceArea(TEST_PYRAMID);
        //then
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testIsPyramidShouldReturnTrueWhenPointsFormPyramid() {
        Assert.assertTrue(calculator.isValidPyramid(firstPoint, secondPoint, thirdPoint, fourthPoint));
    }

    @Test
    public void testIsPyramidShouldReturnFalseWhenThereAreEqualPoints() {
        boolean actual = calculator.isValidPyramid(firstPoint, firstPoint, thirdPoint, fourthPoint);
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsBaseOnCoordinatePlaneShouldReturnTrueWhenItIs() {
        boolean actual = calculator.isBaseOnCoordinatePlane(PYRAMID_ON_PLANE);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBaseOnCoordinatePlaneShouldReturnTrueWhenItIsNot() {
        boolean actual = calculator.isBaseOnCoordinatePlane(TEST_PYRAMID);
        Assert.assertFalse(actual);
    }
}
