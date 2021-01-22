package com.goat.api.designpattern.behavioralmodel.observermodel;

/**
 * 观察者
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
