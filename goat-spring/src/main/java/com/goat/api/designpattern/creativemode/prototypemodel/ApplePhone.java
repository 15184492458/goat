package com.goat.api.designpattern.creativemode.prototypemodel;

/**
 * 创建扩展抽象类的实体类。
 */
public class ApplePhone extends Phone {

    ApplePhone(){
        this.type = "Apple";
    }

    @Override
    void call() {
        System.out.println("ApplePhone call.");
    }
}
