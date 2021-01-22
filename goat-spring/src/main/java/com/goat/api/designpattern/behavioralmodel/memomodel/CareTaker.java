package com.goat.api.designpattern.behavioralmodel.memomodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录管理
 */
public class CareTaker {

    private List<Memento> mementos = new ArrayList();

    public void add(Memento memento){
        mementos.add(memento);
    }

    public Memento get(int index){
        return mementos.get(index);
    }
}
