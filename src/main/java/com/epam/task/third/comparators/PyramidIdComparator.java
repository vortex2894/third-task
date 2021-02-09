package com.epam.task.third.comparators;

import com.epam.task.third.entities.IdentifiablePyramid;

import java.util.Comparator;

public class PyramidIdComparator implements Comparator<IdentifiablePyramid> {
    @Override
    public int compare(IdentifiablePyramid firstPyramid, IdentifiablePyramid secondPyramid) {
        return Long.compare(firstPyramid.getId(), secondPyramid.getId());
    }
}
