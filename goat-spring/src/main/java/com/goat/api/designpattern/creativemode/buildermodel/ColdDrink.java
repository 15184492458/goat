package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 饮料默认用瓶装
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
