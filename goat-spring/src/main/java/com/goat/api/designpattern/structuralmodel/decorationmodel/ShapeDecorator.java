package com.goat.api.designpattern.structuralmodel.decorationmodel;

/**
 * 创建实现了Shape 接口的抽象装饰类。
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    ShapeDecorator(Shape shape){
        this.decoratedShape = shape;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
