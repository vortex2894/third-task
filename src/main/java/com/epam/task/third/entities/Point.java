package com.epam.task.third.entities;

import java.util.List;

public class Point {

    private final int x;
    private final int y;
    private final int z;

    public Point(List<Integer> coordinates) {
        this.x = coordinates.get(0);
        this.y = coordinates.get(1);
        this.z = coordinates.get(2);
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        return (x == ((Point) obj).x) && (y == ((Point) obj).y) && (z == ((Point) obj).z);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString() {
        return "x:" + x + " y:" + y + " z:" + z;
    }

}
