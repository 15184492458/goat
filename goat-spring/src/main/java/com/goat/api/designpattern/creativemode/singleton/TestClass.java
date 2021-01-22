package com.goat.api.designpattern.creativemode.singleton;

/**
 * spring框架中的应用：
 * Spring中bean的默认作用域就是singleton
 */
public class TestClass {

    public static void main(String[] args) {
        SingletonSix x = SingletonSix.INSTANCE;
        SingletonSix y = SingletonSix.INSTANCE;
        System.out.println(x);
        System.out.println(y);
    }
}
