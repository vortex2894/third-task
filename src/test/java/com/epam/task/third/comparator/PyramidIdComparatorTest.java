package com.epam.task.third.comparator;

import com.epam.task.third.comparators.PyramidIdComparator;
import com.epam.task.third.entities.IdentifiablePyramid;
import com.epam.task.third.entities.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PyramidIdComparatorTest {


    private final static Point firstPoint = new Point(3, -1, 1);
    private final static Point secondPoint = new Point(6, 5, 4);
    private final static Point thirdPoint = new Point(4, 2, -1);
    private final static Point fourthPoint = new Point(5, 1, 3);

    private final static IdentifiablePyramid firstPyramid =
            new IdentifiablePyramid(firstPoint, secondPoint, thirdPoint, fourthPoint);

    private final static IdentifiablePyramid secondPyramid =
            new IdentifiablePyramid(secondPoint, thirdPoint, fourthPoint, firstPoint);

    private final static IdentifiablePyramid thirdPyramid =
            new IdentifiablePyramid(thirdPoint, fourthPoint, firstPoint, secondPoint);

    @Test
    public void testSortPyramidsById() {
        PyramidIdComparator comparator = new PyramidIdComparator();
        List<IdentifiablePyramid> actual = Arrays.asList(thirdPyramid, secondPyramid, firstPyramid);
        actual.sort(comparator);
        Assert.assertEquals(Arrays.asList(firstPyramid, secondPyramid, thirdPyramid), actual);
    }
}
