package com.goat.api.designpattern.behavioralmodel.strategymodel;

/**
 * 策略模式:
 *
 * 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 *
 * 意图：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
 *
 * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 *
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 *
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 *
 * 使用场景：
 *      1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 *      2、一个系统需要动态地在几种算法中选择一种。
 *      3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 *
 * 注意事项：如果一个系统的策略多于四个，就需要考虑使用混合模式，解决策略类膨胀的问题。
 *
 *
 *
 * 假设现在要设计一个贩卖各类书籍的电子商务网站的购物车系统。一个最简单的情况就是把所有货品的单价乘上数量，但是实际情况肯定比这要复杂。
 * 比如，本网站可能对所有的高级会员提供每本20%的促销折扣；对中级会员提供每本10%的促销折扣；对初级会员没有折扣。
 * 根据描述，折扣是根据以下的几个算法中的一个进行的：
 *       算法一：对初级会员没有折扣。
 *       算法二：对中级会员提供10%的促销折扣。
 *       算法三：对高级会员提供20%的促销折扣。
 */
public class TestClass {

    public static void main(String[] args) {
        Price price = new Price(new AdvancedMemberStrategy());
        System.out.println("高级会员图书的最终价格为：" + price.cal(10));

        Price p1 = new Price(new IntermediateMemberStrategy());
        System.out.println("中级会员图书的最终价格为：" + p1.cal(10));

        Price p2 = new Price(new PrimaryMemberStrategy());
        System.out.println("初级会员图书的最终价格为：" + p2.cal(10));
    }
}
