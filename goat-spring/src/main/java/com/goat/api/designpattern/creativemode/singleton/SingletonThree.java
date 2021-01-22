package com.goat.api.designpattern.creativemode.singleton;

/**
 * 饿汉式，线程安全，不是懒加载（类装载时就实例化）
 *
 */
public class SingletonThree {

    private static SingletonThree instance = new SingletonThree();

    private SingletonThree(){}

    public static SingletonThree getInstance(){
        return instance;
    }
}
