package com.goat.api.designpattern.creativemode.prototypemodel;

/**
 * spring框架中的应用：
 * Spring中bean的默认作用域就是singleton。除了singleton作用域,Spring bean还有下面几种作用域
 * prototype : 每次请求都会创建一个新的 bean 实例。
 */
public class TestClass {

    public static void main(String[] args) {
        PhoneCache.loadCache();
        Phone clonedShape1 = PhoneCache.getPhone("1");
        System.out.println("Phone : " + clonedShape1.getType());
        clonedShape1.call();

        Phone clonedShape2 = PhoneCache.getPhone("2");
        System.out.println("Phone : " + clonedShape2.getType());
        clonedShape2.call();
    }
}
