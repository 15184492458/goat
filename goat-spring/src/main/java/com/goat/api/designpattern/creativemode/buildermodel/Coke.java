package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 可乐
 * 创建扩展了ColdDrink的实体类。
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke Drink";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
