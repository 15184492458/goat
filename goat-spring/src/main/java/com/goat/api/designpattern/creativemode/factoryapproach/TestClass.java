package com.goat.api.designpattern.creativemode.factoryapproach;

public class TestClass {

    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        Fruit apple = appleFactory.createFruit();
        apple.plant();
        apple.grow();
        apple.pick();
        BananaFactory bananaFactory = new BananaFactory();
        Fruit banana = bananaFactory.createFruit();
        banana.plant();
        banana.grow();
        banana.pick();
    }
}
