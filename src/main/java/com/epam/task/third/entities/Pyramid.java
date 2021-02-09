package com.epam.task.third.entities;

import java.util.HashSet;
import java.util.List;

public class Pyramid {

    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    public Pyramid(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    public Pyramid(List<Integer> coordinates) {
        firstPoint = new Point(coordinates.get(0), coordinates.get(1), coordinates.get(2));
        secondPoint = new Point(coordinates.get(3), coordinates.get(4), coordinates.get(5));
        thirdPoint = new Point(coordinates.get(6), coordinates.get(7), coordinates.get(8));
        fourthPoint = new Point(coordinates.get(9), coordinates.get(10), coordinates.get(11));

        new Pyramid(firstPoint, secondPoint, thirdPoint, fourthPoint);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public Point getFourthPoint() {
        return fourthPoint;
    }

    public void setPoints(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        HashSet<Point> firstHashSet = new HashSet<>();
        firstHashSet.add(firstPoint);
        firstHashSet.add(secondPoint);
        firstHashSet.add(thirdPoint);
        firstHashSet.add(fourthPoint);

        HashSet<Point> secondHashSet = new HashSet<>();
        secondHashSet.add(((Pyramid) obj).getFirstPoint());
        secondHashSet.add(((Pyramid) obj).getSecondPoint());
        secondHashSet.add(((Pyramid) obj).getThirdPoint());
        secondHashSet.add(((Pyramid) obj).getFourthPoint());
        return firstHashSet.equals(secondHashSet);
    }

    @Override
    public int hashCode() {
        int result = firstPoint != null ? firstPoint.hashCode() : 0;
        result = 31 * result + (secondPoint != null ? secondPoint.hashCode() : 0);
        result = 31 * result + (thirdPoint != null ? thirdPoint.hashCode() : 0);
        result = 31 * result + (fourthPoint != null ? fourthPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "First Point: "
                + firstPoint.toString()
                + " Second Point: " + secondPoint.toString()
                + " Third Point: " + thirdPoint.toString()
                + " Fourth Point: " + fourthPoint.toString();
    }
}
