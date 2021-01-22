package com.goat.api.designpattern.creativemode.prototypemodel;

/**
 * 创建扩展抽象类的实体类。
 */
public class MiPhone extends Phone {

    MiPhone(){
        this.type = "Mi";
    }

    @Override
    void call() {
        System.out.println("MiPhone call.");
    }
}
