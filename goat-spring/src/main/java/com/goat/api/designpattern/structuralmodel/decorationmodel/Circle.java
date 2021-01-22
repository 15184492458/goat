package com.goat.api.designpattern.structuralmodel.decorationmodel;

/**
 * 创建Shape接口实现类
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw");
    }
}
