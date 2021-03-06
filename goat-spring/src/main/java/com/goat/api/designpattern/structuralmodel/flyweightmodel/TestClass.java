package com.goat.api.designpattern.structuralmodel.flyweightmodel;

/**
 * 享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，
 * 它提供了减少对象数量从而改善应用所需的对象结构的方式。
 * 享元模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。我们将通过创建 5 个对象来画出 20 个分布于不同位置
 * 的圆来演示这种模式。由于只有 5 种可用的颜色，所以 color 属性被用来检查现有的 Circle 对象。
 *
 * 应用实例： 1、JAVA 中的 String，如果有则返回，如果没有则创建一个字符串保存在字符串缓存池里面。 2、数据库的数据池。
 *
 * 优点：大大减少对象的创建，降低系统的内存，使效率提高。
 *
 * 缺点：提高了系统的复杂度，需要分离出外部状态和内部状态，而且外部状态具有固有化的性质，不应该随着内部状态的变化而变化，否则会造成系统的混乱。
 *
 * 使用场景： 1、系统有大量相似对象。 2、需要缓冲池的场景。
 */
public class TestClass {
}
