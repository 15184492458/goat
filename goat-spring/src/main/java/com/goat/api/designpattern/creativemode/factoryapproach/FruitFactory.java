package com.goat.api.designpattern.creativemode.factoryapproach;

/**
 * 工厂方法模式:
 *
 * 抽象工厂角色
 *
 * 工厂方法模式去掉了简单工厂模式中工厂方法的静态属性，使得它可以被子类继承。
 * 这样在简单工厂模式里集中在工厂方法上的压力可以由工厂方法模式里不同的工厂子类来分担。
 *
 * 工厂方法模式组成：
 *   1)抽象工厂角色：这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。在java中它由抽象类或者接口来实现。
 *   2)具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。
 *   3)抽象产品角色：它是具体产品继承的父类或者是实现的接口。在java中一般有抽象类或者接口来实现。
 *   4)具体产品角色：具体工厂角色所创建的对象就是此角色的实例。在java中由具体的类来实现。
 *
 *  工厂方法模式使用继承自抽象工厂角色的多个子类来代替简单工厂模式中的“上帝类”。正如上面所说，这样便分担了对象承受的压力；
 *  而且这样使得结构变得灵活 起来——当有新的产品产生时，只要按照抽象产品角色、抽象工厂角色提供的合同来生成，那么就可以被客户使用，
 *  而不必去修改任何已有 的代码。可以看出工厂角色的结构也是符合开闭原则的！
 */
public interface FruitFactory {

    public Fruit createFruit();
}
