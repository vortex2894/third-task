package com.epam.task.third.observers;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
}
