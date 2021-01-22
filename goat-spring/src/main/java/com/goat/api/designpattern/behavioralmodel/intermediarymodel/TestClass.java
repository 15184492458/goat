package com.goat.api.designpattern.behavioralmodel.intermediarymodel;

/**
 * 中介者模式：
 *      中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，
 *      该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。中介者模式属于行为型模式。
 *
 * 我们通过聊天室实例来演示中介者模式。实例中，多个用户可以向聊天室发送消息，聊天室向所有的用户显示消息。我们将创建两个类
 * ChatRoom 和 User。User 对象使用 ChatRoom 方法来分享他们的消息。TestClass我们的演示类使用 User 对象来显示他们之间的通信。
 */
public class TestClass {

    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");
        robert.sendMessage("Hello, John");
        john.sendMessage("Hello, Robert");
    }
}
