package com.epam.task.third.entities;

public class Id {

    private static long count = 0;
    private long id;

    public Id() {
        id = (count++);
    }

    public long getId() {
        return id;
    }

}
