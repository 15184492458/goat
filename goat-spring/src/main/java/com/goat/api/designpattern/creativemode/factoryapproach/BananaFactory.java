package com.goat.api.designpattern.creativemode.factoryapproach;

public class BananaFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Banana();
    }
}
