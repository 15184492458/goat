package com.goat.api.designpattern.creativemode.abstractfactory;

/**
 * 正方形
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw square");
    }
}
