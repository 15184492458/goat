package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。(默认纸包装)
 */
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();
}
