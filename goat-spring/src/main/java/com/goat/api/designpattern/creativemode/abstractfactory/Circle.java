package com.goat.api.designpattern.creativemode.abstractfactory;

/**
 * 圆形
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw circle");
    }
}
