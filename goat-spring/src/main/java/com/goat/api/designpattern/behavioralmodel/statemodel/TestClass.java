package com.goat.api.designpattern.behavioralmodel.statemodel;

/**
 * 状态模式
 *
 * 在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。
 * 在状态模式中，我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。
 *
 * 主要解决：对象的行为依赖于它的状态（属性），并且可以根据它的状态改变而改变它的相关行为。
 *
 * 何时使用：代码中包含大量与对象状态有关的条件语句。
 *
 * 优点：
 *      1、封装了转换规则。
 *      2、枚举可能的状态，在枚举状态之前需要确定状态种类。
 *      3、将所有与某个状态有关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象状态即可改变对象的行为。
 *      4、允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块。
 *      5、可以让多个环境对象共享一个状态对象，从而减少系统中对象的个数。
 *
 * 使用场景： 1、行为随状态改变而改变的场景。 2、条件、分支语句的代替者。
 *
 * 注意事项：在行为受状态约束的时候使用状态模式，而且状态不超过 5 个。
 *
 * 以学生成绩为例，每次考完试，都根据成绩修改状态。
 */
public class TestClass {
    public static void main(String[] args) {
        ScoreContext context = new ScoreContext();
        context.setScore(20);
        context.setScore(70);
        context.setScore(90);
        context.setScore(20);
    }
}
