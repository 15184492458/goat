package com.goat.api.designpattern.structuralmodel.decorationmodel;

/**
 * 创建Shape接口实现类
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle draw");
    }
}
