package com.goat.api.designpattern.structuralmodel.decorationmodel;

/**
 * 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
 *
 * 我们将创建一个 Shape 接口和实现了 Shape 接口的实体类。然后我们创建一个实现了 Shape 接口的抽象装饰类 ShapeDecorator，并把 Shape 对象作为它的实例变量。
 * RedShapeDecorator 是实现了 ShapeDecorator 的实体类。TestClass 类使用 RedShapeDecorator 来装饰 Shape 对象。
 *
 * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 *
 * 缺点：多层装饰比较复杂。
 *
 * 使用场景： 1、扩展一个类的功能。 2、动态增加功能，动态撤销。
 */
public class TestClass {

    public static void main(String[] args) {
        ShapeDecorator circleDecorator = new RedShapeDecorator(new Circle());
        ShapeDecorator rectangleDecorator = new RedShapeDecorator(new Rectangle());
        circleDecorator.draw();
        rectangleDecorator.draw();
    }
}
