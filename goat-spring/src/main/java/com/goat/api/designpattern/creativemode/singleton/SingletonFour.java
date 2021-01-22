package com.goat.api.designpattern.creativemode.singleton;

/**
 * 双重锁检查,线程安全，懒加载
 */
public class SingletonFour {

    /**
     * volatile 线程可见性，不保证原子性，防止指令重排
     */
    private static volatile SingletonFour instance;

    private SingletonFour(){}

    public static SingletonFour getInstance() {
        if (instance == null) {
            synchronized(SingletonFour.class){
                if (instance == null) {
                    instance = new SingletonFour();
                }
            }
        }
        return instance;
    }
}
