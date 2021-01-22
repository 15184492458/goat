package com.goat.api.designpattern.behavioralmodel.observermodel;

/**
 * 观察者模式：
 *
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知依赖它的对象。观察者模式属于行为型模式。
 *
 * 观察者模式使用三个类 Subject、Observer 和 Client。Subject 对象带有绑定观察者到 Client 对象和从 Client 对象解绑观察者的方法。
 * 我们创建Subject类、Observer抽象类和扩展了抽象类Observer的实体类。TestClass我们的演示类使用Subject和实体类对象来演示观察者模式。
 */
public class TestClass {

    public static void main(String[] args) {
        Subject subject = new Subject();//创建一个主题
        new BinaryObserver(subject);//创建一个BinaryObserver并订阅主题
        new OctalObserver(subject);//创建一个OctalObserver并订阅主题
        new HexaObserver(subject);//创建一个HexaObserver并订阅主题
        System.out.println("Set state = 1");
        subject.setState(1);//更新主题的状态时，通知以上所有的观察者

        System.out.println("Set state = 2");
        subject.setState(2);//更新主题的状态时，通知以上所有的观察者
    }
}
