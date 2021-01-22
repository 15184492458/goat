package com.goat.api.designpattern.creativemode.buildermodel;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi Drink";
    }

    @Override
    public float price() {
        return 2.5f;
    }
}
