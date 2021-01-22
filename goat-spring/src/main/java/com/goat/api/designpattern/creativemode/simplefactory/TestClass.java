package com.goat.api.designpattern.creativemode.simplefactory;

/**
 * spring框架中的应用：
 * Spring使用工厂模式可以通过BeanFactory或ApplicationContext创建bean对象。
 */
public class TestClass {

    public static void main(String[] args) {
        Car car = CarFactory.getCar("Benz");
        if (car != null){
            car.run();
            car.stop();
        }
    }
}
