package com.goat.api.designpattern.creativemode.singleton;

/**
 * 枚举,线程安全，不是懒加载
 * 这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 */
public enum SingletonSix {

    INSTANCE;

    public void getInstance(){}
}
