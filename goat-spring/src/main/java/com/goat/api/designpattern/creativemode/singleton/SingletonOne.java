package com.goat.api.designpattern.creativemode.singleton;

/**
 * 懒汉式，线程不安全
 */
public class SingletonOne {

    private static SingletonOne instance;

    /**
     *  构造器私有化
     */
    private SingletonOne(){}

    public static SingletonOne getInstance() {
        if (instance == null){
            instance = new SingletonOne();
        }
        return instance;
    }
}
