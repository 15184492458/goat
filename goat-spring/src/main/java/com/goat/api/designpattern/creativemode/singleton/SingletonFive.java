package com.goat.api.designpattern.creativemode.singleton;

/**
 * 静态内部类，线程安全，懒加载
 */
public class SingletonFive {

    private SingletonFive(){}

    public static SingletonFive getInstance(){
        return SingletonFiveHolder.INSTANCE;
    }

    private static class SingletonFiveHolder{

        private final static SingletonFive INSTANCE = new SingletonFive();
    }
}
