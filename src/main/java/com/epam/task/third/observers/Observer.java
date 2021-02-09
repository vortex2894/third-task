package com.epam.task.third.observers;

import com.epam.task.third.observers.impl.PyramidObservable;

public interface Observer {

    void update(PyramidObservable pyramid);
}
