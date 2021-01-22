package com.goat.api.designpattern.creativemode.simplefactory;

/**
 * Product
 * 抽象类产品 : 工厂类所创建的所有对象的父类，封装了产品对象的公共方法，所有的具体产品为其子类对象
 */
public interface Car {

    public void run();

    public void stop();
}
