package com.goat.api.designpattern.creativemode.abstractfactory;

/**
 * 矩形形状
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw rectangle");
    }
}
