package com.goat.api.designpattern.behavioralmodel.commandmodel;

/**
 * 命令模式：
 *      命令模式（Command Pattern）是一种数据驱动的设计模式，它属于行为型模式。请求以命令的形式包裹在对象中，并传给调用对象。
 *      调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
 *
 * 意图：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
 *
 * 主要解决：
 *      在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，但某些场合，比如需要对行为进行记录、撤销或重做、事务等处理时，
 *      这种无法抵御变化的紧耦合的设计就不太合适。
 *
 * 何时使用：
 *      在某些场合，比如要对行为进行"记录、撤销/重做、事务"等处理，这种无法抵御变化的紧耦合是不合适的。在这种情况下，
 *      如何将"行为请求者"与"行为实现者"解耦？将一组行为抽象为对象，可以实现二者之间的松耦合。
 *
 * 如何解决：
 *      通过调用者调用接受者执行命令，顺序：调用者→命令→接受者。
 *
 * 使用场景：认为是命令的地方都可以使用命令模式，比如： 1、GUI 中每一个按钮都是一条命令。 2、模拟 CMD。
 *
 * 我们首先创建作为命令的接口 Order，然后创建作为请求的 Stock 类。实体命令类 BuyStock 和 SellStock，实现了 Order 接口，将执行实际的命令处理。
 * 创建作为调用对象的类 Broker，它接受订单并能下订单。Broker 对象使用命令模式，基于命令的类型确定哪个对象执行哪个命令。
 * TestClass 类使用 Broker 类来演示命令模式。
 */
public class TestClass {

    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
