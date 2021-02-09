package com.epam.task.third.entities;

import java.util.List;

public class IdentifiablePyramid extends Pyramid {
    private final Id id;

    public IdentifiablePyramid(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint);
        this.id = new Id();
    }

    public IdentifiablePyramid(List<Integer> coordinates) {
        super(coordinates);
        this.id = new Id();
    }

    public long getId() {
        return this.id.getId();

    }
}
