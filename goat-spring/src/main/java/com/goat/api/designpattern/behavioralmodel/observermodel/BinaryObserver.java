package com.goat.api.designpattern.behavioralmodel.observermodel;

public class BinaryObserver extends Observer {

    /**
     * 构造器
     * 当创建时定义这个观察者订阅的主题，并调用主题的attach方法将观察者添加至主题的集合中
     * @param subject
     */
    BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
