package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 瓶包装
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
