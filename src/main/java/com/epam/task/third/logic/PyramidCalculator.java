package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Pyramid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PyramidCalculator {

    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    private void init(Pyramid pyramid) {
        this.firstPoint = pyramid.getFirstPoint();
        this.secondPoint = pyramid.getSecondPoint();
        this.thirdPoint = pyramid.getThirdPoint();
        this.fourthPoint = pyramid.getFourthPoint();
    }

    public double countSurfaceArea(Pyramid pyramid) {
        init(pyramid);
        double s1 = countTriangleArea(firstPoint, secondPoint, thirdPoint);
        double s2 = countTriangleArea(firstPoint, secondPoint, fourthPoint);
        double s3 = countTriangleArea(firstPoint, thirdPoint, fourthPoint);
        double s4 = countTriangleArea(secondPoint, thirdPoint, fourthPoint);
        return s1 + s2 + s3 + s4;
    }

    public double countVolume(Pyramid pyramid) {
        init(pyramid);
        int ax = secondPoint.getX() - firstPoint.getX();
        int ay = secondPoint.getY() - firstPoint.getY();
        int az = secondPoint.getZ() - firstPoint.getZ();
        int bx = thirdPoint.getX() - firstPoint.getX();
        int by = thirdPoint.getY() - firstPoint.getY();
        int bz = thirdPoint.getZ() - firstPoint.getZ();
        int cx = fourthPoint.getX() - firstPoint.getX();
        int cy = fourthPoint.getY() - firstPoint.getY();
        int cz = fourthPoint.getZ() - firstPoint.getZ();

        int determinant = (
                ax * by * cz - ax * cy * bz
                        - ay * bx * cz + ay * cx * bz + az * bx * cy
                        - az * cx * by);
        double volume = (double) determinant / 6;
        return Math.abs(volume);
    }

    public boolean isBaseOnCoordinatePlane(Pyramid pyramid) {
        init(pyramid);
        return isOnXPlane() || isOnYPlane() || isOnZPlane();
    }


    public boolean isValidPyramid(Point firstPoint,
                                   Point secondPoint,
                                   Point thirdPoint,
                                   Point fourthPoint) {
        Set<Point> hashSet = new HashSet<>(Arrays.asList(
                firstPoint, secondPoint, thirdPoint, fourthPoint));
        return hashSet.size() == 4;
    }

    private double getDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2)
                + Math.pow(firstPoint.getY() - secondPoint.getY(), 2)
                + Math.pow(firstPoint.getZ() - secondPoint.getZ(), 2));
    }

    private double countTriangleArea(Point firstPoint, Point secondPoint, Point thirdPoint) {
        double a = getDistanceBetweenTwoPoints(firstPoint, secondPoint);
        double b = getDistanceBetweenTwoPoints(secondPoint, thirdPoint);
        double c = getDistanceBetweenTwoPoints(firstPoint, thirdPoint);
        double P = (a + b + c) / 2;
        return Math.sqrt(P * (P - a) * (P - b) * (P - c));
    }

    private boolean isOnXPlane() {
        boolean firstOption = (firstPoint.getX() == 0)
                && (secondPoint.getX() == 0) && (thirdPoint.getX() == 0);
        boolean secondOption = (firstPoint.getX() == 0)
                && (secondPoint.getX() == 0) && (fourthPoint.getX() == 0);
        boolean thirdOption = (secondPoint.getX() == 0)
                && (thirdPoint.getX() == 0) && (fourthPoint.getX() == 0);
        boolean fourthOption = (firstPoint.getX() == 0)
                && (thirdPoint.getX() == 0) && (fourthPoint.getX() == 0);
        return firstOption || secondOption || thirdOption || fourthOption;
    }

    private boolean isOnYPlane() {
        boolean firstOption = (firstPoint.getY() == 0)
                && (secondPoint.getY() == 0) && (thirdPoint.getY() == 0);
        boolean secondOption = (firstPoint.getY() == 0)
                && (secondPoint.getY() == 0) && (fourthPoint.getY() == 0);
        boolean thirdOption = (secondPoint.getY() == 0)
                && (thirdPoint.getY() == 0) && (fourthPoint.getY() == 0);
        boolean fourthOption = (firstPoint.getY() == 0)
                && (thirdPoint.getY() == 0)
                && (fourthPoint.getY() == 0);
        return firstOption || secondOption || thirdOption || fourthOption;
    }

    private boolean isOnZPlane() {
        boolean firstVariant = (firstPoint.getZ() == 0)
                && (secondPoint.getZ() == 0) && (thirdPoint.getZ() == 0);
        boolean secondVariant = (firstPoint.getZ() == 0)
                && (secondPoint.getZ() == 0) && (fourthPoint.getZ() == 0);
        boolean thirdVariant = (secondPoint.getZ() == 0)
                && (thirdPoint.getZ() == 0) && (fourthPoint.getZ() == 0);
        boolean fourthVariant = (firstPoint.getZ() == 0)
                && (thirdPoint.getZ() == 0) && (fourthPoint.getZ() == 0);
        return firstVariant || secondVariant || thirdVariant || fourthVariant;
    }
}
