package com.goat.api.designpattern.creativemode.simplefactory;

/**
 * 简单工厂模式
 *
 * 工厂:核心部分，负责实现创建所有产品的内部逻辑，工厂类可以被外界直接调用，创建所需对象
 *
 * 简单工厂模式概述:
 *      定义一个工厂类，他可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类
 *      在简单工厂模式中用于被创建实例的方法通常为静态(static)方法,因此简单工厂模式又被成为静态工厂方法(Static Factory Method)
 *      需要什么，只需要传入一个正确的参数，就可以获取所需要的对象，而无需知道其实现过程
 *
 *  例如，开一家披萨店，当客户需要某种披萨并且我这家店里也能做的时候，我就会为其提供所需要的披萨,如果其所需的我这没有，
 *  则是另外的情况，后面会谈。这时候，我这家披萨店就可以看做工厂(Factory),而生产出来的披萨被成为产品(Product),披萨的名称则被称为参数，
 *  工厂可以根据参数的不同返回不同的产品，这就是简单工厂模式
 */
public class CarFactory {

    public static Car getCar(String type){
        Car car = null;
        if("Benz".equals(type)){
            car = new Benz();
        }else if("Ford".equals(type)){
            car = new Ford();
        }else {
            System.out.println("不能生产这个类型的汽车");
        }
        return car;
    }
}
