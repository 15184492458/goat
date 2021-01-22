package com.goat.api.designpattern.behavioralmodel.observermodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题
 */
public class Subject {

    /*主题的状态*/
    private int state;

    /*订阅这个主题的所有观察者*/
    private List<Observer> observers = new ArrayList<Observer>();

    public int getState() {
        return state;
    }

    /**
     * 当主题的状态改变时，设置主题的状态并调用notifyAllObservers方法通知所有的观察者
     * @param state
     */
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * 添加观察者
     * @param observer
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 通知所有的观察者
     */
    public void notifyAllObservers(){
        for (Observer observer : observers) {//通过循环所有的观察者，调用观察者的update方法通知
            observer.update();
        }
    }
}
