package com.goat.api.designpattern.structuralmodel.decorationmodel;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 创建扩展了ShapeDecorator类的实体装饰类。
 */
public class RedShapeDecorator extends ShapeDecorator {

    RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
