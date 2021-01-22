package com.goat.api.designpattern.creativemode.factoryapproach;

public class Apple implements Fruit {
    @Override
    public void plant() {
        System.out.println("Apple plant");
    }

    @Override
    public void grow() {
        System.out.println("Apple grow");
    }

    @Override
    public void pick() {
        System.out.println("Apple pick");
    }
}
