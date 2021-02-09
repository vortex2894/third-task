package com.epam.task.third.observers;

import com.epam.task.third.entities.Point;
import com.epam.task.third.observers.impl.PyramidObservable;
import com.epam.task.third.observers.impl.PyramidObserver;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PyramidObservableTest {

    private final static List<Integer> TEST_COORDINATES =
            Arrays.asList(3, 5, 3, 6, 2, 4, 1, 3, 2, 4, 5, 9);

    private final PyramidObservable pyramid = new PyramidObservable(TEST_COORDINATES);

    private final static Point FIRST_POINT = new Point(2, 4, 3);
    private final static Point SECOND_POINT = new Point(3, 5, 6);
    private final static Point THIRD_POINT = new Point(-2, 0, 0);
    private final static Point FOURTH_POINT = new Point(14, 17, 11);

    private final static PyramidObserver observer = PyramidObserver.getInstance();

    @Test
    public void testSetPointsShouldSetPyramidPoints() {
        pyramid.setPoints(FIRST_POINT, SECOND_POINT, THIRD_POINT, FOURTH_POINT);
        PyramidObservable expected = new PyramidObservable(FIRST_POINT, SECOND_POINT, THIRD_POINT, FOURTH_POINT);
        Assert.assertEquals(pyramid, expected);
    }

    @Test
    public void testAttachObserver() {
        pyramid.attach(observer);
        List<Observer> expected = Collections.singletonList(observer);
        List<Observer> actual = pyramid.getObservers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetachObserver() {
        pyramid.detach(observer);
        List<Observer> expected = Collections.emptyList();
        List<Observer> actual = pyramid.getObservers();
        Assert.assertEquals(expected, actual);
    }
}
