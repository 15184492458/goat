package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 创建扩展了Burger的实体类。
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
