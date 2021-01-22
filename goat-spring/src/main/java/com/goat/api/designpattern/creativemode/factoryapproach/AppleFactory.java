package com.goat.api.designpattern.creativemode.factoryapproach;

public class AppleFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
