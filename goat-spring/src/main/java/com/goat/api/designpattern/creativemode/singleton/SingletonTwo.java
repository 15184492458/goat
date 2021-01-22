package com.goat.api.designpattern.creativemode.singleton;

/**
 * 懒汉式，线程安全
 * synchronized关键字加锁
 */
public class SingletonTwo {

    private static SingletonTwo instance;

    private SingletonTwo (){}

    public static synchronized SingletonTwo getInstance(){
        if (instance == null) {
            instance = new SingletonTwo();
        }
        return instance;
    }
}
