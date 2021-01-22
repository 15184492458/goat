package com.goat.api.designpattern.creativemode.factoryapproach;

public class Banana implements Fruit {
    @Override
    public void plant() {
        System.out.println("Banana plant");
    }

    @Override
    public void grow() {
        System.out.println("Banana grow");
    }

    @Override
    public void pick() {
        System.out.println("Banana pick");
    }
}
