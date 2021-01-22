package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 创建扩展了Burger的实体类。
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}
