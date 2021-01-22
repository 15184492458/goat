package com.goat.api.designpattern.creativemode.abstractfactory;

/**
 * 创建一个工厂创造器/生成器类FactoryProducer，通过传递形状或颜色信息来获取工厂。
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice == null) return null;
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
